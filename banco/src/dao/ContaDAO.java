package dao;

import java.sql.ResultSet;

import database.DatabaseUtil;
import model.Conta;
import model.ContaNormal;
import model.Titular;

public class ContaDAO {

    // 🔹 Inserir conta
    public static void inserirConta(Conta conta, int titularId) {

        String sql = String.format("""
            INSERT INTO conta (numero_conta, saldo, titular_id)
            VALUES (%d, %f, %d);
        """, conta.getNumeroConta(), conta.getSaldo(), titularId);

        DatabaseUtil.executar(sql);
    }

    // 🔹 Buscar conta pelo titular
    public static Conta buscarPorTitular(int titularId, Titular titular) {

        String sql = String.format("""
            SELECT * FROM conta WHERE titular_id = %d;
        """, titularId);

        ResultSet rs = DatabaseUtil.consultar(sql);

        try {
            if (rs != null && rs.next()) {

                Conta conta = new ContaNormal(titular);

                conta.depositar(rs.getDouble("saldo"));

                return conta;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 🔹 Atualizar saldo
    public static void atualizarSaldo(Conta conta) {

        String sql = String.format("""
            UPDATE conta SET saldo = %f WHERE numero_conta = %d;
        """, conta.getSaldo(), conta.getNumeroConta());

        DatabaseUtil.executar(sql);
    }


    
}