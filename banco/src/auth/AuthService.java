package auth;

import dao.TitularDAO;
import model.Titular;

public class AuthService {

    // 🔹 verificar se email já existe
    public static boolean emailExiste(String email) {
        if (email == null) return false;

        return TitularDAO.selecionarTitularPorEmail(email) != null;
    }

    // 🔹 login
    public static Titular login(String email, String senha) {

    Titular titular = TitularDAO.selecionarTitularPorEmail(email);

    if (titular != null && titular.autenticar(email, senha)) {

        // 🔥 AQUI É O PONTO CERTO
        titular.inicializarConta();

        return titular;
    }

    return null;
}
}