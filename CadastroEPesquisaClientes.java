import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CadastroEPesquisaClientes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroEPesquisaClientesUI();
            }
        });
    }
}

class CadastroEPesquisaClientesUI {
    private HashMap<String, Cliente> tabelaHash;

    public CadastroEPesquisaClientesUI() {
        tabelaHash = new HashMap<>();

        JFrame frame = new JFrame("Sistema de Gestão de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(10, 10, 80, 25);
        panel.add(labelNome);

        JTextField fieldNome = new JTextField(20);
        fieldNome.setBounds(100, 10, 280, 25);
        panel.add(fieldNome);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(10, 40, 80, 25);
        panel.add(labelCPF);

        JTextField fieldCPF = new JTextField(20);
        fieldCPF.setBounds(100, 40, 280, 25);
        panel.add(fieldCPF);

        JLabel labelTelefone = new JLabel("Telefone (WhatsApp):");
        labelTelefone.setBounds(10, 70, 130, 25);
        panel.add(labelTelefone);

        JTextField fieldTelefone = new JTextField(20);
        fieldTelefone.setBounds(150, 70, 230, 25);
        panel.add(fieldTelefone);

        JCheckBox mesmoNumeroWhatsapp = new JCheckBox("Mesmo número para WhatsApp");
        mesmoNumeroWhatsapp.setBounds(150, 100, 230, 25);
        panel.add(mesmoNumeroWhatsapp);

        JButton buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setBackground(Color.white);
        buttonCadastrar.setForeground(Color.black);

        buttonCadastrar.setBounds(10, 130, 100, 25);
        buttonCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = fieldNome.getText();
                String cpf = fieldCPF.getText();
                String telefone = fieldTelefone.getText();
                boolean mesmoNumero = mesmoNumeroWhatsapp.isSelected();

                Cliente cliente = new Cliente(nome, cpf, telefone, mesmoNumero);
                tabelaHash.put(cpf, cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            }
        });
        panel.add(buttonCadastrar);

        JLabel labelBuscarCPF = new JLabel("Buscar cliente por CPF:");
        labelBuscarCPF.setBounds(10, 160, 120, 25);
        panel.add(labelBuscarCPF);

        JTextField fieldBuscarCPF = new JTextField(20);
        fieldBuscarCPF.setBounds(130, 160, 130, 25);
        panel.add(fieldBuscarCPF);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.setBackground(Color.white);
        buttonBuscar.setForeground(Color.black);
        buttonBuscar.setBounds(270, 160, 100, 25);
        buttonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfBusca = fieldBuscarCPF.getText();
                Cliente cliente = tabelaHash.get(cpfBusca);
                if (cliente != null) {
                    String mensagem = "Cliente encontrado:\nNome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf() + "\nTelefone (WhatsApp): " + cliente.getTelefone();
                    if (cliente.isMesmoNumero()) {
                        mensagem += "\nO mesmo número é utilizado para WhatsApp.";
                    } else {
                        mensagem += "\nO cliente possui outro número para WhatsApp.";
                    }
                    JOptionPane.showMessageDialog(null, mensagem);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                }
            }
        });
        panel.add(buttonBuscar);

        frame.add(panel);
        frame.setVisible(true);
    }
}