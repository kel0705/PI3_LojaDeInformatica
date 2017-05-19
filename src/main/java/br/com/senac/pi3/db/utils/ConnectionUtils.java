package br.com.senac.pi3.db.utils;
/**
 *
 * @author Jonathan Souza
 */
import br.com.senac.pi.constants.MainConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

//Obtém um objeto de conexão do banco de dados.
//Pode ser utilizado para abertura e fechamento de conexões com o banco
public class ConnectionUtils {

    //Obtém uma conexão do banco de dados
    public static Connection getConnection() {
        //Conexão para abertura e fechamento
        Connection connection = null;
        try {
            //Só tenta abrir uma conexão se não existir ou estiver fechada            
            //Endereço de conexão com o banco de dados
            String dbURL = MainConstants.DB_ADDRESS;
            //Propriedades para armazenamento de usuário e senha
            Properties properties = new Properties();
            properties.put("user", MainConstants.DB_USER);
            properties.put("password", MainConstants.DB_PASS);
            //Realiza a conexão com o banco
            connection = DriverManager.getConnection(dbURL, properties);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Retorna a conexão
        return connection;
    }
    
    public static String convDataBanco(String dataSistema) {
    java.util.Date dataFormatada;
    String dataBanco = "";//variavel que vai receber a data para o banco
    try {//Conversão da data do sistema para formato da data do Banco
        dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataSistema);
        dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
    } catch (ParseException ex) {
    }
    
    return dataBanco;
}
}
