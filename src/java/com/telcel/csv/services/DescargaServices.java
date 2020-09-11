/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.csv.services;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.infomedia.utils.PropertyLoader;
import com.telcel.sir.pojos.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;
/**
 *
 * @author Vladimir C
 */
public class DescargaServices {

    public static final Properties vpProp = PropertyLoader.load("rutas.properties");
    private static final Logger log = Logger.getLogger(DescargaServices.class);

    
    private String vsRutaLocal = vpProp.getProperty("RUTA_LOCAL");
    private String vsRutaNomina = vpProp.getProperty("RUTA_NOMINA");
    private String vsRutaNominaB = vpProp.getProperty("RUTA_NOMINAB");
    private String vsRutaCrear = vpProp.getProperty("RUTA_CREAR");
    
    private String vsRutaLocalEx = vpProp.getProperty("RUTA_LOCALEX");
    private String vsRutaNominaEx = vpProp.getProperty("RUTA_NOMINAEX");
    private String vsRutaNominaExB = vpProp.getProperty("RUTA_NOMINAEXB");
    private String vsRutaCrearEx = vpProp.getProperty("RUTA_CREAREX");

    

    public boolean fncControl() {
        System.out.println("Inicio");
        boolean vbRes = false;

        String file4 = vsRutaLocal.substring(2, vsRutaLocal.length()) + fncFecha() + ".csv";
        String file5 = vsRutaNomina + fncFecha() + ".xls";
        
        List<User> poUsers = fncLeerUsers(file4);
        NominasEXccel(file5, poUsers);
        NominasEXccelBCK(vsRutaNominaB, poUsers);
        fncCrearArchivo(poUsers, vsRutaCrear);

        file4 = vsRutaLocalEx.substring(2, vsRutaLocalEx.length()) + fncFecha() + ".csv";
        file5 = vsRutaNominaEx + fncFecha() + ".xls";
        
        poUsers.clear();
        poUsers = fncLeerUsers(file4);
        NominasEXccel(file5, poUsers);
        NominasEXccelBCK(vsRutaNominaExB, poUsers);
        fncCrearArchivo(poUsers, vsRutaCrearEx);

        return vbRes;
    }

    public String fncFecha() {
        SimpleDateFormat voFormat = new SimpleDateFormat("yyyyMMdd");
        //Date voFecha = new Date();
        Calendar voCalendario = new GregorianCalendar();
        voCalendario.add(Calendar.DAY_OF_YEAR, 0);
        String fecha = voFormat.format(voCalendario.getTime());
        return fecha;
    }

    public List<User> fncLeerUsers(String psRuta) {
        List<User> voUsers = new ArrayList<>();
        User voUser;
        CsvReader voLector = null;
        try {
            voLector = new CsvReader(psRuta);
            voLector.readHeaders();
            while (voLector.readRecord()) {
                if (!voLector.get(0).isEmpty()) {
                    voUser = new User();
                    
                    voUser.setNumEmp(voLector.get(0));
                    voUser.setUsuario(voLector.get(1));
                    voUser.setNombreC(voLector.get(2));
                    voUser.setPaterno(voLector.get(3));
                    voUser.setMaterno(voLector.get(4));
                    voUser.setNombre(voLector.get(5));
                    voUser.setCorreo(voLector.get(6));
                    voUser.setRegion(voLector.get(7));
                    voUser.setIdRegion(voLector.get(8));
                    voUser.setDir(voLector.get(9));
                    voUser.setIdDir(voLector.get(10));
                    voUser.setSubDir(voLector.get(11));
                    voUser.setIdSubDir(voLector.get(12));
                    voUser.setGerencia(voLector.get(13));
                    voUser.setIdGer(voLector.get(14));
                    voUser.setDepto(voLector.get(15));
                    voUser.setIdDepto(voLector.get(16));
                    voUser.setPuesto(voLector.get(17));
                    voUser.setIdPuesto(voLector.get(18));
                    voUser.setEmpresa(voLector.get(19));
                    voUser.setCentroCostos(voLector.get(20));
                    voUser.setContrato(voLector.get(21));
                    voUser.setNumJefe(voLector.get(22));
                    voUser.setJefe(voLector.get(23));
                    voUser.setEdif(voLector.get(24));
                    voUser.setPatMat(voLector.get(25));
                    voUser.setDes1(voLector.get(26));
                    voUser.setDes2(voLector.get(27));
                    voUser.setHorario(voLector.get(28));
                    voUser.setFechaM(voLector.get(29));       
                    voUsers.add(voUser);
                }
            }
            voLector.close();

        } catch (Exception e) {
            log.error(e);
        } finally {
            if (voLector != null) {
                voLector.close();
            }
        }
        return voUsers;
    }

    public void fncCrearArchivo(List<User> poUsers, String rutaA) {
        
                
        String vsArchivoRuta = rutaA + fncFecha() + ".csv";
        if (new File(vsArchivoRuta).exists()) {
            new File(vsArchivoRuta).delete();
        }
        try {
            OutputStream voSalida = new FileOutputStream(vsArchivoRuta);
            CsvWriter csvOutput = new CsvWriter(voSalida, ',', Charset.forName("iso-8859-1"));
            csvOutput.write("Numero de empleado");
            csvOutput.write("Usuario universal");
            csvOutput.write("Nombre completo");
            csvOutput.write("Paterno");
            csvOutput.write("Materno");
            csvOutput.write("Nombre");
            csvOutput.write("Cuenta de correo");
            csvOutput.write("Region");
            csvOutput.write("IdRegion");
            csvOutput.write("Direccion");
            csvOutput.write("IdDireccion");
            csvOutput.write("Subdireccion");
            csvOutput.write("IdSubdireccion");
            csvOutput.write("Gerencia");
            csvOutput.write("IdGerencia");
            csvOutput.write("Departamento");
            csvOutput.write("IdDepartamento");
            csvOutput.write("Puesto");
            csvOutput.write("IdPuesto");
            csvOutput.write("Empresa");
            csvOutput.write("CentroCostos");
            csvOutput.write("Tipo contrato");
            csvOutput.write("Numero de empelado Jefe");
            csvOutput.write("Jefe inmediato");
            csvOutput.write("Edificio");
            csvOutput.write("Paterno materno");
            csvOutput.write("Descanso1");
            csvOutput.write("Descanso2");
            csvOutput.write("Horario");
            csvOutput.write("Fecha de movimiento");
            csvOutput.write("Puesto anterior");
            csvOutput.write("Puesto en nomina");
            csvOutput.endRecord();

            for (User poUser : poUsers) {
                
                csvOutput.write(poUser.getNumEmp());
                csvOutput.write(poUser.getUsuario());
                csvOutput.write(poUser.getNombreC());
                csvOutput.write(poUser.getPaterno());
                csvOutput.write(poUser.getMaterno());
                csvOutput.write(poUser.getNombre());
                csvOutput.write(poUser.getCorreo());
                csvOutput.write(poUser.getRegion());
                csvOutput.write(poUser.getIdRegion());
                csvOutput.write(poUser.getDir());
                csvOutput.write(poUser.getIdDir());
                csvOutput.write(poUser.getSubDir());
                csvOutput.write(poUser.getIdSubDir());
                csvOutput.write(poUser.getGerencia());
                csvOutput.write(poUser.getIdGer());
                csvOutput.write(poUser.getDepto());
                csvOutput.write(poUser.getIdDepto());
                csvOutput.write(poUser.getPuesto());
                csvOutput.write(poUser.getIdPuesto());
                csvOutput.write(poUser.getEmpresa());
                csvOutput.write(poUser.getCentroCostos());
                csvOutput.write(poUser.getContrato());
                csvOutput.write(poUser.getNumJefe());
                csvOutput.write(poUser.getJefe());
                csvOutput.write(poUser.getEdif());
                csvOutput.write(poUser.getPatMat());
                csvOutput.write(poUser.getDes1());
                csvOutput.write(poUser.getDes2());
                csvOutput.write(poUser.getHorario());
                csvOutput.write(poUser.getFechaM());
                csvOutput.write(poUser.getPuestoAnt());
                csvOutput.write(poUser.getPuestoNomina());
                csvOutput.endRecord();
            }
            csvOutput.close();
        } catch (Exception e) {
        }
    }
    
    
/*     */   public void NominasEXccel(String Ruta, List<User> poUsers)
/*     */   {
              System.out.println("Agregar info de " + Ruta);
/* 739 */     String[][] arginternos = (String[][])null;
/*     */     try
/*     */     {
/* 743 */       WorkbookSettings configurar = new WorkbookSettings();
/* 744 */       configurar.setEncoding("iso-8859-1");
/* 745 */       Workbook workbook = Workbook.getWorkbook(new File(Ruta), configurar);
/* 746 */       Sheet sheet = workbook.getSheet(0);
/*     */       
/*     */ 
/* 749 */       arginternos = new String[sheet.getRows()-4][sheet.getColumns()];
/* 751 */       for (int fila = 4; fila < sheet.getRows(); fila++) {
/* 752 */         for (int columna = 0; columna < sheet.getColumns(); columna++) {
/* 753 */           arginternos[fila-4][columna] = sheet.getCell(columna, fila).getContents();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (IOException ex) {
/* 846 */       log.error(ex);
/*     */     } catch (BiffException ex) {
/* 848 */       log.error(ex);
/*     */     }

            String[] arginternosC = (String[])null;
            arginternosC = getColumn(arginternos, 0);

            for (User poUser : poUsers) {
                for(int i = 0; i < arginternosC.length; i++)
                {
                    if(arginternosC[i].equals(poUser.getNumEmp()))
                    {
                        poUser.setPuestoNomina(arginternos[i][17]);
                        break;
                    }
                }          
            }
            System.out.println("Columna agregada");

/*     */   }



/*     */   public void NominasEXccelBCK(String Ruta, List<User> poUsers)
/*     */   {
              System.out.println("Agregar info de " + Ruta);
/* 739 */     String[][] arginternos = (String[][])null;
/*     */     try
/*     */     {
/* 743 */       WorkbookSettings configurar = new WorkbookSettings();
/* 744 */       configurar.setEncoding("iso-8859-1");
/* 745 */       Workbook workbook = Workbook.getWorkbook(new File(Ruta), configurar);
/* 746 */       Sheet sheet = workbook.getSheet(0);
/*     */       
/*     */ 
/* 749 */       arginternos = new String[sheet.getRows()-4][sheet.getColumns()];
/* 751 */       for (int fila = 4; fila < sheet.getRows(); fila++) {
/* 752 */         for (int columna = 0; columna < sheet.getColumns(); columna++) {
/* 753 */           arginternos[fila-4][columna] = sheet.getCell(columna, fila).getContents();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (IOException ex) {
/* 846 */       log.error(ex);
/*     */     } catch (BiffException ex) {
/* 848 */       log.error(ex);
/*     */     }
               

            String[] arginternosC = (String[])null;
            arginternosC = getColumn(arginternos, 0);

            for (User poUser : poUsers) {
                for(int i = 0; i < arginternosC.length; i++)
                {
                    if(arginternosC[i].equals(poUser.getNumEmp()))
                    {
                        poUser.setPuestoAnt(arginternos[i][17]);
                        break;
                    }
                }          
            }
            System.out.println("Columna agregada");

/*     */   }


    public static String[] getColumn(String[][] array, int index){
        String[] column = new String[array.length];
        for(int i=0; i<column.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }

}
