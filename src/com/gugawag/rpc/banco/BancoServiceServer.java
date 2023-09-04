package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    // private Map<String, Double> saldoContas;
    private List<Conta> contas;


    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();

        contas.add(new Conta("1", 100.0));
        // comentario
//        saldoContas = new HashMap<>();
//        saldoContas.put("1", 100.0);
//        saldoContas.put("2", 156.0);
//        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return contas.get(Integer.parseInt(conta)-1).getSaldo();
        //return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
        //return saldoContas.size();
    }

    @Override
    public void adicionarConta(double saldoConta) throws RemoteException {

        Conta novaConta = new Conta(Integer.toString(quantidadeContas()+1), saldoConta);
        contas.add(novaConta);

    }

}
