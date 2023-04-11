package Aplicacion._11_20_Cliente;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id_cliente;
    private String name;
    private int phoneNumber;

     public Cliente(int id_cliente, String name, int phoneNumber) {
        this.id_cliente = id_cliente;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
            return "Cliente{" +
                    "id='" +id_cliente+ '\'' +
                    ", name='" +name+ '\'' +
                    ", phone number='" +phoneNumber  + '\''+
                    '}';
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setIdCliente(int newIdCliente) {
         this.id_cliente = id_cliente;
    }

    public void setNameCliente(String newNameCliente) {
         this.name = name;
    }

    public void setPhoneNumber(int newPhoneNum) {
         this.phoneNumber = phoneNumber;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
