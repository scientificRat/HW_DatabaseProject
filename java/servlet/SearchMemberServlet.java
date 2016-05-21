package servlet;

import utility.MemberData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by huangzhengyue on 5/21/16.
 */
@WebServlet("/query")
public class SearchMemberServlet extends HttpServlet{

    private String databaseUrl="jdbc:postgresql://localhost/database_project";

    Driver driver=null;

    Connection dbConnection=null;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //null
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");
        String way=req.getParameter("way");
        String data=req.getParameter("data");

        if(way.equals("")||data.equals("")){
            req.getSession().setAttribute("error",new String("查询错误,请重新输入"));
            resp.sendRedirect("/index.jsp");
            return;
        }

        req.getSession().setAttribute("error","");

        ArrayList<MemberData> memberDatas=query(way,data);

        req.getSession().setAttribute("memberDatas",memberDatas);

        resp.sendRedirect("/show.jsp");




    }

    private void connectDataBase(){
        driver=new org.postgresql.Driver();

        try {
            DriverManager.registerDriver(driver);
            dbConnection=DriverManager.getConnection(databaseUrl,"huangzhengyue",null);

        } catch (SQLException e) {
            for (Throwable t:
                 e) {
                t.printStackTrace();
            }
        }

    }


    private ArrayList<MemberData> query(String way,String data){
        connectDataBase();

        ArrayList<MemberData> memberDatas=new ArrayList<>();
        PreparedStatement prStat=null;

        String stuId;
        String name;
        String birthDay;
        String hobies;


        try {

            if(way.equals("name")){
                prStat=dbConnection.prepareStatement("SELECT * FROM team_member WHERE name=?");
                prStat.setString(1,data);

            }
            else if(way.equals("id")){
                prStat=dbConnection.prepareStatement("SELECT * FROM team_member WHERE stu_id=?");
                prStat.setString(1,data);
            }
            else if(way.equals("hobby")){
                prStat=dbConnection.prepareStatement("SELECT * FROM team_member WHERE hobies LIKE ?");
                prStat.setString(1,"%"+data+"%");
            }
            ResultSet rs=prStat.executeQuery();

            while (rs.next()){
                stuId=rs.getString("stu_id");
                name=rs.getString("name");
                birthDay=rs.getString("birthday");
                hobies=rs.getString("hobies");
                memberDatas.add(new MemberData(stuId,name,birthDay,hobies));
            }

        }
        catch (SQLException e) {
            for (Throwable t: e) {
                t.printStackTrace();
            }
        }
        finally {

            try {
                dbConnection.close();
            }
            catch (SQLException e) {
                for (Throwable t: e) {
                    t.printStackTrace();
                }
            }
        }
        return memberDatas;
    }



}
