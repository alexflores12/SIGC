package Services;

import Beans.UsuarioBE;
import DAO.UsuarioDA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuarioBL {

    public UsuarioBL() {
    }

    public UsuarioBE listarUsuarioBE(UsuarioBE oUsuarioBE1) {
        UsuarioBE oUsuarioBE = null;
        UsuarioDA oUsuarioDA = null;
        try {
            oUsuarioDA = new UsuarioDA();
            oUsuarioBE = oUsuarioDA.listarUsuarioBE(oUsuarioBE1);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oUsuarioBE1 = null;
            oUsuarioDA = null;
        }
        return oUsuarioBE;
    }

    public List<Integer> obtenerIdVistaByUsuario(UsuarioBE oUsuarioBE) {

        UsuarioDA oUsuarioDA = new UsuarioDA();
        return oUsuarioDA.obtenerIdVistaByUsuario(oUsuarioBE);
    }

    public ArrayList<UsuarioBE> listarRegistrosUsuarioBE(UsuarioBE oUsuarioBE) {
        ArrayList<UsuarioBE> oListaUsuarioBE = null;
        UsuarioDA oUsuarioDA = null;
        try {
            oUsuarioDA = new UsuarioDA();
            oListaUsuarioBE = oUsuarioDA.listarRegistroUsuarioBE(oUsuarioBE);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oUsuarioBE = null;
            oUsuarioDA = null;
        }
        return oListaUsuarioBE;
    }

    public int insertarUsuarioBE(UsuarioBE oUsuarioBE) {
        int resultado = 0;
        UsuarioDA oUsuarioDA = null;

        try {
            oUsuarioDA = new UsuarioDA();
            resultado = oUsuarioDA.insertarUsuarioBE(oUsuarioBE);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oUsuarioBE = null;
            oUsuarioDA = null;
        }
        return resultado;
    }

    public int insertarRegistrosUsuarioBE(ArrayList<UsuarioBE> oListaUsuarioBE) {
        int resultado = 0;
        UsuarioDA oUsuarioDA = null;

        try {
            oUsuarioDA = new UsuarioDA();
            resultado = oUsuarioDA.insertarRegistrosUsuarioBE(oListaUsuarioBE);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oListaUsuarioBE = null;
            oUsuarioDA = null;
        }
        return resultado;
    }

    public int actualizarUsuarioBE(UsuarioBE oUsuarioBE1) {
        int resultado = 0;
        UsuarioDA oUsuarioDA = null;
        try {
            oUsuarioDA = new UsuarioDA();
            resultado = oUsuarioDA.actualizarUsuarioBE(oUsuarioBE1);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oUsuarioBE1 = null;
            oUsuarioDA = null;
        }

        return resultado;
    }

    public DefaultTableModel listarModeloRegistrosUsuarioBE(Object[] cabeceras, UsuarioBE oUsuarioBE1) {
        DefaultTableModel modelo = null;

        Object[] fila = null;
        ArrayList<UsuarioBE> oListaUsuarioBE = null;
        UsuarioDA oUsuarioDA = null;

        try {
            modelo = new DefaultTableModel();
            oUsuarioDA = new UsuarioDA();
            oListaUsuarioBE = oUsuarioDA.listarRegistroUsuarioBE(oUsuarioBE1);
            modelo.setColumnIdentifiers(cabeceras);

            for (UsuarioBE oUsuario : oListaUsuarioBE) {
                fila = new Object[13];
                fila[0] = oUsuario.getIdusuario();
                fila[1] = oUsuario.getUsuario();
                //fila[2]=oUsuario.getContrasenia();
                fila[2] = oUsuario.getNombre();
                fila[3] = oUsuario.getAppaterno();
                fila[4] = oUsuario.getApmaterno();
                fila[5] = oUsuario.getIdrol();
                //fila[7]=oUsuario.getTelefonofijo();
                // fila[8]=oUsuario.getTelefonomovil();
                // fila[9]=oUsuario.getDireccion();
                // fila[10]=oUsuario.getEmail();
                // fila[11]=oUsuario.getIdtiposexo();
                fila[6] = oUsuario.getEstado();
                modelo.addRow(fila);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            oUsuarioBE1 = null;
            oUsuarioDA = null;
        }

        return modelo;
    }

    public UsuarioBE findUsuarioByUserAndPass(String usuario, String contrasenia) {

        // validar el nombre de usuario y password
        // de tal manera que no sean vacios y no sean
        // iguales entre si
        UsuarioDA oUsuarioDA = new UsuarioDA();
        UsuarioBE oUsuarioBE = new UsuarioBE();

        oUsuarioBE = oUsuarioDA.findUsuarioByUserAndPass(
                usuario, contrasenia);

        return oUsuarioBE;
    }

    public List<UsuarioBE> listarPersonas() {
        // Medina Jayo y Roca

        UsuarioDA oUsuarioDA = new UsuarioDA();
        UsuarioBE oUsuarioBE = new UsuarioBE();
        //se guarda la lista en oListaUsuarioBE
        List<UsuarioBE> oListaUsuarioBE = oUsuarioDA.listarPersonas();

        //retornando la lista UsuarioBE
        return oListaUsuarioBE;

    }

    public UsuarioBE findUsuarioById(int id) {
        // Quispe

        return null;
    }

    public UsuarioBE updateCuentaUser(UsuarioBE oUsuarioBE) {

        UsuarioDA oUusuarioDA = new UsuarioDA();

        String usuario, contrasenia, estado;

        usuario = (oUsuarioBE.getUsuario());
        contrasenia = (oUsuarioBE.getContrasenia());
        estado = (oUsuarioBE.getEstado() + "");

        if (usuario.equals("") || contrasenia.equals("")
                || estado.equals("")) {

            oUsuarioBE.setIndOpSp(3);
            return oUsuarioBE;
        } else {
            UsuarioBE resultados = oUusuarioDA.updateUser(oUsuarioBE);
            return resultados;
        }
    }

    public UsuarioBE updateUser(UsuarioBE oUsuarioBE) {

        UsuarioDA oUusuarioDA = new UsuarioDA();
        //extraer los compos para realizar las modificaciones 
        String nombre, apepaterno, apematerno, direccion, nrodocumento, telefonomovil;

        nombre = (oUsuarioBE.getNombre());
        apepaterno = (oUsuarioBE.getAppaterno());
        apematerno = (oUsuarioBE.getApmaterno());
        direccion = (oUsuarioBE.getDireccion());
        nrodocumento = (oUsuarioBE.getNrodocumento());
        telefonomovil = (oUsuarioBE.getTelefonomovil());
        // si al menos un   campo no debe  estár vacio, el foco apunta a q debe 
        //tener los datos  para poder actualizar.

        if (nombre.equals("") || apepaterno.equals("")
                || apematerno.equals("") || direccion.equals("")
                || nrodocumento.equals("") || telefonomovil.equals("")) {
            //realiza la comparacion para poder hacer la actualizacion
            oUsuarioBE.setIndOpSp(3);
            return oUsuarioBE;
        } else {
            UsuarioBE resultados = oUusuarioDA.updateUser(oUsuarioBE);
            return resultados;
        }
    }

    public UsuarioBE addUser(UsuarioBE oUsuarioBE) {

        UsuarioDA oUusuarioDA = new UsuarioDA();
        String nombre, apepaterno, apematerno, direccion, nrodocumento, telefonomovil;

        nombre = (oUsuarioBE.getNombre());
        apepaterno = (oUsuarioBE.getAppaterno());
        apematerno = (oUsuarioBE.getApmaterno());
        direccion = (oUsuarioBE.getDireccion());
        nrodocumento = (oUsuarioBE.getNrodocumento());
        telefonomovil = (oUsuarioBE.getTelefonomovil());
        // si al menos un   campo no debe  contener datos, el foco apunta a q debe 
        //tener los datos  para poder agregar.

        if (nombre.equals("") || apepaterno.equals("")
                || apematerno.equals("") || direccion.equals("")
                || nrodocumento.equals("") || telefonomovil.equals("")) {

            oUsuarioBE.setIndOpSp(3);
            return oUsuarioBE;
        } else {
            return oUusuarioDA.addUser(oUsuarioBE);
        }

    }
    
    public List<UsuarioBE> listarPersonas(String algo) {
        // Medina Jayo y Roca

        UsuarioDA oUsuarioDA = new UsuarioDA();
        UsuarioBE oUsuarioBE = new UsuarioBE();
        //se guarda la lista en oListaUsuarioBE
        List<UsuarioBE> oListaUsuarioBE = oUsuarioDA.listarPersonas(algo);

        //retornando la lista UsuarioBE
        return oListaUsuarioBE;

    }

    public List<UsuarioBE> findUsuarioByNombre(String nombre) {
        UsuarioDA oUsuarioDA = new UsuarioDA();
        List<UsuarioBE> listaUsuarios = oUsuarioDA.findUsuarioByNombre(nombre);
        return listaUsuarios;

    }

    public List<UsuarioBE> findUsuarioByAppaterno(String appaterno) {
        UsuarioDA oUsuarioDA = new UsuarioDA();
        List<UsuarioBE> listaUsuarios = oUsuarioDA.findUsuarioByAppaterno(appaterno);
        return listaUsuarios;

    }

    public List<UsuarioBE> findUsuarioByNrodocumento(String nrodocumento) {
        UsuarioDA oUsuarioDA = new UsuarioDA();
        List<UsuarioBE> listaUsuarios = oUsuarioDA.findUsuarioByNrodocumento(nrodocumento);
        return listaUsuarios;
    }

    public UsuarioBE findUsuarioByIdusuario(int idusuario) {
       UsuarioDA oUsuarioDA = new UsuarioDA();
       UsuarioBE oUsuarioBE = new UsuarioBE();

        oUsuarioBE = oUsuarioDA.findUsuarioByIdusuario(idusuario);
                
        return oUsuarioBE;

    }
}
