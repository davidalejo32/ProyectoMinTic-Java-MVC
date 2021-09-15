package modelo;

public class ParticipanteModel {

    //atributos 
    private String par_login;
    private String par_nombre;
    private String par_apellido;
    private String par_email;
    private long   par_celular;
    private String par_clave;
    private String par_fecha_nto;

    
    //constructor original
    public ParticipanteModel(String par_login, String par_nombre, String par_apellido, String par_email, long par_celular, String par_clave, String par_fecha_nto) {
        this.par_login     = par_login;
        this.par_nombre    = par_nombre;
        this.par_apellido  = par_apellido;
        this.par_email     = par_email;
        this.par_celular   = par_celular;
        this.par_clave     = par_clave;
        this.par_fecha_nto = par_fecha_nto;
    }
    
    //constuctor de salida de la tabla queri
    public ParticipanteModel(String par_login, String par_nombre, String par_apellido, long par_celular) {
        this.par_login    = par_login;
        this.par_nombre   = par_nombre;
        this.par_apellido = par_apellido;
        this.par_celular  = par_celular;
    }
    
    public ParticipanteModel() {
    }
    

    /**
     * @return the par_login
     */
    public String getPar_login() {
        return par_login;
    }

    
    /**
     * @return the par_nombre
     */
    public String getPar_nombre() {
        return par_nombre;
    }

    
    /**
     * @return the par_apellido
     */
    public String getPar_apellido() {
        return par_apellido;
    }

    
    /**
     * @return the par_email
     */
    public String getPar_email() {
        return par_email;
    }


    /**
     * @return the par_celular
     */
    public long getPar_celular() {
        return par_celular;
    }

    
    /**
     * @return the par_clave
     */
    public String getPar_clave() {
        return par_clave;
    }

    
    /**
     * @return the par_fecha_nto
     */
    public String getPar_fecha_nto() {
        return par_fecha_nto;
    }
    
    
    /**
     * @param par_email the par_email to set
     */
    public void setPar_email(String par_email) {
        this.par_email = par_email;
    }
    
    
    /**
     * @param par_celular the par_celular to set
     */
    public void setPar_celular(long par_celular) {
        this.par_celular = par_celular;
    }
    
    
    /**
     * @param par_clave the par_clave to set
     */
    public void setPar_clave(String par_clave) {
        this.par_clave = par_clave;
    }
    
    
    /**
     * @param par_nombre the par_nombre to set
     */
    public void setPar_nombre(String par_nombre) {
        this.par_nombre = par_nombre;
    }

    
    /**
     * @param par_apellido the par_apellido to set
     */
    public void setPar_apellido(String par_apellido) {
        this.par_apellido = par_apellido;
    }

    
    /**
     * @param par_fecha_nto the par_fecha_nto to set
     */
    public void setPar_fecha_nto(String par_fecha_nto) {
        this.par_fecha_nto = par_fecha_nto;
    }

    
    /**
     * @param par_login the par_login to set
     */
    public void setPar_login(String par_login) {
        this.par_login = par_login;
    }
    
    
    //metodo Tabla1
    
    public Object[] toArrayTabla1(){
        Object[] datat1 ={getPar_login(), getPar_nombre(), getPar_apellido(), getPar_celular()};
        return datat1;
    }
    //metodo Tabla 2
    public Object[] toArrayTabla2(){
        Object[] datat2 ={getPar_login(), getPar_nombre(), getPar_apellido(), getPar_email(), getPar_celular(), getPar_clave(), getPar_fecha_nto()};
        return datat2;
    }
   
    

    
    
    
    
    }
