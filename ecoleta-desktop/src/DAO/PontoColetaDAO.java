package DAO;

import Utils.ConexaoBanco;
import entity.CollectPoint;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PontoColetaDAO {

    public static ArrayList<CollectPoint> buscarPontoPelaCidade(String cidade) {
        ArrayList<CollectPoint> pontos = new ArrayList<>();
        String sql = "SELECT * FROM ponto WHERE cidade = ?";
        try (PreparedStatement stm = ConexaoBanco.getConexao().prepareStatement(sql)) {
            stm.setString(1, cidade);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id_ponto = rs.getInt("id_ponto");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Double latitude = rs.getDouble("latitude");
                Double longetude = rs.getDouble("longetude");
                pontos.add(new CollectPoint(id_ponto, nome, email, cidade, latitude, longetude));
            }
        } catch (SQLException e) {
            System.out.println("não deu");
            return null;
        }

        return pontos;
    }

    public static boolean pontoColetaExiste(String nome) {
        String sql = "SELECT * FROM ponto WHERE nome = ?";
        try (PreparedStatement stm = ConexaoBanco.getConexao().prepareStatement(sql)) {
            stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Falha ao verificar o nome do ponto de coleta");
        }
        return false;
    }

    public static void cadastrarPontoColeta(CollectPoint point) {
        if (pontoColetaExiste(point.getNome())) {
            System.out.println("Já existe um ponto de coleta com esse nome");
            return;
        }

        String sql = "INSERT INTO ponto (nome, email, cidade, latitude, longetude) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = ConexaoBanco.getConexao().prepareStatement(sql)) {
            stm.setString(1, point.getNome());
            stm.setString(2, point.getEmail());
            stm.setString(3, point.getCidade());
            stm.setDouble(4, point.getLatitude());
            stm.setDouble(5, point.getLongitute());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Falha ao cadastrar ponto de coleta");
        }
    }
}
