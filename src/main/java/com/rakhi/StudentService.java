package com.rakhi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentService {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql =
                "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL
    public void showAllStudents() {

        String sql = "SELECT * FROM students";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BY ID
    public void searchStudent(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Student Found!");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE BY ID
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE BY ID
    public void updateStudent(int id, String name, int age) {

        String sql =
                "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}