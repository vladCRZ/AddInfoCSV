/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.sir.pojos;

/**
 *
 * @author 
 */
public class User {
    private String NumEmp;
    private String Usuario;
    private String NombreC;
    private String Paterno;
    private String Materno;
    private String Nombre;
    private String Correo;
    private String Region;
    private String IdRegion;
    private String Dir;
    private String IdDir;
    private String SubDir;
    private String IdSubDir;
    private String Gerencia;
    private String IdGer;
    private String Depto;
    private String IdDepto;
    private String Puesto;
    private String IdPuesto;
    private String Empresa;
    private String CentroCostos;
    private String Contrato;
    private String NumJefe;
    private String Jefe;
    private String Edif;
    private String PatMat;
    private String Des1;
    private String Des2;
    private String Des3;
    private String Horario;
    private String FechaM;
    private String PuestoAnt;
    private String PuestoNomina;
    
    public User(){
    }

    public String getNumEmp() {
        return NumEmp;
    }

    public void setNumEmp(String NumEmp) {
        this.NumEmp = NumEmp;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String NombreC) {
        this.NombreC = NombreC;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(String IdRegion) {
        this.IdRegion = IdRegion;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public String getIdDir() {
        return IdDir;
    }

    public void setIdDir(String IdDir) {
        this.IdDir = IdDir;
    }

    public String getSubDir() {
        return SubDir;
    }

    public void setSubDir(String SubDir) {
        this.SubDir = SubDir;
    }

    public String getIdSubDir() {
        return IdSubDir;
    }

    public void setIdSubDir(String IdSubDir) {
        this.IdSubDir = IdSubDir;
    }

    public String getGerencia() {
        return Gerencia;
    }

    public void setGerencia(String Gerencia) {
        this.Gerencia = Gerencia;
    }

    public String getIdGer() {
        return IdGer;
    }

    public void setIdGer(String IdGer) {
        this.IdGer = IdGer;
    }

    public String getDepto() {
        return Depto;
    }

    public void setDepto(String Depto) {
        this.Depto = Depto;
    }

    public String getIdDepto() {
        return IdDepto;
    }

    public void setIdDepto(String IdDepto) {
        this.IdDepto = IdDepto;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getIdPuesto() {
        return IdPuesto;
    }

    public void setIdPuesto(String IdPuesto) {
        this.IdPuesto = IdPuesto;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getCentroCostos() {
        return CentroCostos;
    }

    public void setCentroCostos(String CentroCostos) {
        this.CentroCostos = CentroCostos;
    }

    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String Contrato) {
        this.Contrato = Contrato;
    }

    public String getNumJefe() {
        return NumJefe;
    }

    public void setNumJefe(String NumJefe) {
        this.NumJefe = NumJefe;
    }

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String Jefe) {
        this.Jefe = Jefe;
    }

    public String getEdif() {
        return Edif;
    }

    public void setEdif(String Edif) {
        this.Edif = Edif;
    }

    public String getPatMat() {
        return PatMat;
    }

    public void setPatMat(String PatMat) {
        this.PatMat = PatMat;
    }

    public String getDes1() {
        return Des1;
    }

    public void setDes1(String Des1) {
        this.Des1 = Des1;
    }

    public String getDes2() {
        return Des2;
    }

    public void setDes2(String Des2) {
        this.Des2 = Des2;
    }

    public String getDes3() {
        return Des3;
    }

    public void setDes3(String Des3) {
        this.Des3 = Des3;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public String getFechaM() {
        return FechaM;
    }

    public void setFechaM(String FechaM) {
        this.FechaM = FechaM;
    }

    public String getPuestoAnt() {
        return PuestoAnt;
    }

    public void setPuestoAnt(String PuestoAnt) {
        this.PuestoAnt = PuestoAnt;
    }

    public String getPuestoNomina() {
        return PuestoNomina;
    }

    public void setPuestoNomina(String PuestoNomina) {
        this.PuestoNomina = PuestoNomina;
    }

    @Override
    public String toString() {
        return "User{" + "NumEmp=" + NumEmp + ", Usuario=" + Usuario + ", NombreC=" + NombreC + ", Paterno=" + Paterno + ", Materno=" + Materno + ", Nombre=" + Nombre + ", Correo=" + Correo + ", Region=" + Region + ", IdRegion=" + IdRegion + ", Dir=" + Dir + ", IdDir=" + IdDir + ", SubDir=" + SubDir + ", IdSubDir=" + IdSubDir + ", Gerencia=" + Gerencia + ", IdGer=" + IdGer + ", Depto=" + Depto + ", IdDepto=" + IdDepto + ", Puesto=" + Puesto + ", IdPuesto=" + IdPuesto + ", Empresa=" + Empresa + ", CentroCostos=" + CentroCostos + ", Contrato=" + Contrato + ", NumJefe=" + NumJefe + ", Jefe=" + Jefe + ", Edif=" + Edif + ", PatMat=" + PatMat + ", Des1=" + Des1 + ", Des2=" + Des2 + ", Des3=" + Des3 + ", Horario=" + Horario + ", FechaM=" + FechaM + ", PuestoAnt=" + PuestoAnt + ", PuestoNomina=" + PuestoNomina + '}';
    }
    
    

    
}
