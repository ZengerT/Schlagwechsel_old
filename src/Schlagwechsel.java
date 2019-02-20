import javax.swing.*;

public class Schlagwechsel {
    private JButton btnGenerate;
    private JFrame frame;
    private JTextField tfTurnier;
    private JTextField tfMann;
    private JTextField tfRunden;

    public JButton getBtnGenerate() {
        return this.btnGenerate;
    }

    public void setBtnGenerate(JButton btnGenerate) {
        this.btnGenerate = btnGenerate;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTfTurnier() {
        return this.tfTurnier;
    }

    public void setTfTurnier(JTextField tfTurnier) {
        this.tfTurnier = tfTurnier;
    }

    public JTextField getTfMann() {
        return this.tfMann;
    }

    public void setTfMann(JTextField tfMann) {
        this.tfMann = tfMann;
    }

    public JTextField getTfRunden() {
        return this.tfRunden;
    }

    public void setTfRunden(JTextField tfRunden) {
        this.tfRunden = tfRunden;
    }

    public Schlagwechsel() {
        this.initialize();
    }

    private void initialize() {
        this.frame = new JFrame("Schlagwechsel");
        this.frame.setBounds(100, 100, 400, 200);
        this.frame.setDefaultCloseOperation(3);
        JLabel lblTurnier = new JLabel("Name Turnier");
        JLabel lbl_mann = new JLabel("Anzahl Mannschaften");
        JLabel lblRunden = new JLabel("Anzahl Runden");
        this.tfTurnier = new JTextField();
        this.tfTurnier.setColumns(10);
        this.tfMann = new JTextField();
        this.tfMann.setColumns(10);
        this.tfRunden = new JTextField();
        this.tfRunden.setColumns(10);
        this.btnGenerate = new JButton("Generate");
        GroupLayout groupLayout = new GroupLayout(this.frame.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(25).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblTurnier).addComponent(lbl_mann).addComponent(lblRunden)).addGap(35).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.tfRunden, -2, -1, -2).addComponent(this.tfMann, -2, -1, -2).addComponent(this.tfTurnier, -2, -1, -2)).addContainerGap(71, 32767)).addGroup(groupLayout.createSequentialGroup().addContainerGap(275, 32767).addComponent(this.btnGenerate).addGap(25)));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(23).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblTurnier).addComponent(this.tfTurnier, -2, -1, -2)).addGap(18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lbl_mann).addComponent(this.tfMann, -2, -1, -2)).addGap(18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblRunden).addComponent(this.tfRunden, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.btnGenerate).addContainerGap()));
        this.frame.getContentPane().setLayout(groupLayout);
    }
}
