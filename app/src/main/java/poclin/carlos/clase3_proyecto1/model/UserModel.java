package poclin.carlos.clase3_proyecto1.model;

/**
 * Created by Alumno on 24/09/2017.
 */

public class UserModel {

    public static final String TABLE_NAME = "usuario";
    public static final String NAMES_FIELD = "nombres";
    public static final String AP_FIELD = "ap";
    public static final String AM_FIELD = "am";
    public static final String CORREO_FIELD = "correo";
    public static final String PASS_FIELD = "pass";

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String pass;

    public UserModel(String nombres, String apellidoPaterno, String apellidoMaterno, String correo, String pass) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.pass = pass;
    }

    public UserModel() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
