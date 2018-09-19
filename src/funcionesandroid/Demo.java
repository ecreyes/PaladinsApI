package funcionesandroid;

public class Demo {

    public static void main(String[] args) {
        //obtener sesion. una vez obtenida comenten el url para no generar otra sesion
       /*
        String url = Paladins.getUrltoSession();
        System.out.println(url);
        */
        
        //la session obtenida agregarla aca
        
        Paladins.setSessionID("E0C06B2114304CC49BE7AE1A15B62F3A");
        String url_random = Paladins.getUrl("getchampions");
        System.out.println(url_random);
        
    }    
}
