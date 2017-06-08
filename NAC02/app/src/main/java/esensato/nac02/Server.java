package esensato.nac02;


public class Server {

    public static String request() {

        String json = "[{\"acao\":\"Banco Norte\", \"valor\":100.00},\n" +
                "{\"acao\":\"Mineradora Mineira\", \"valor\":50.00},\n" +
                "{\"acao\":\"Mutan TI\", \"valor\":80.00},\n" +
                "{\"acao\":\"Construtora Casa\", \"valor\":110.00}]";

        return json;


    }
}
