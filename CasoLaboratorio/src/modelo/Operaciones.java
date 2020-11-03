package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conexion;

/**
 * @author Nashiro
 */public class Operaciones extends conexion {


    public boolean agregar(Dispositivo dis) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT dispositivo (NSerie,sede,equipo,marca,año) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dis.getNSerie());
            ps.setString(2, dis.getSede());
            ps.setString(3, dis.getEquipo());
            ps.setString(4, dis.getMarca());
            ps.setInt(5, dis.getAño());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Dispositivo dis) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE dispositivo SET sede=?,equipo=?,marca=?,año=? WHERE NSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dis.getSede());
            ps.setString(2, dis.getEquipo());
            ps.setString(3, dis.getMarca());
            ps.setInt(4, dis.getAño());
            ps.setInt(5, dis.getNSerie());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Dispositivo dis) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM dispositivo WHERE NSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dis.getNSerie());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean buscar(Dispositivo dis){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM dispositivo WHERE NSerie = ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dis.getNSerie());
            rs = ps.executeQuery();
            if (rs.next()) {
                dis.setNSerie(Integer.parseInt(rs.getString("NSerie")));
                dis.setSede(rs.getString("Sede"));
                dis.setEquipo(rs.getString("Equipo"));
                dis.setMarca(rs.getString("Marca"));
                dis.setAño(Integer.parseInt(rs.getString("Año")));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
