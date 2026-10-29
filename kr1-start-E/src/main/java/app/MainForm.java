package app;

import com.formdev.flatlaf.FlatLightLaf;
import static java.awt.SystemColor.text;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 * Начална форма за контролна работа № 1, вариант E (Рецепти).
 * Всички контроли са поставени и кръстени. Кодът ви влиза в конструктора
 * (след initComponents) и в методите на събитията. Блокът между
 * GEN-BEGIN и GEN-END се генерира от дизайнера и не се редактира.
 */


public class MainForm extends javax.swing.JFrame {
private List<Recipe> items = new ArrayList<>();
private List<Recipe> shown;
private DefaultTableModel tableModel;
private DefaultListModel<Recipe> listModel;
private DefaultComboBoxModel<String> cuisinez;
private Timer statusTimer;

    public MainForm() {
        initComponents();
        //bonus 
        statusTimer = new Timer(3000, e -> lblStatus.setText("Готово."));
statusTimer.setRepeats(false);
        //zad5
        cuisinez = new DefaultComboBoxModel<>();
        String[] arrCuisinez = {"Всички","Българска","Италианска","Азиатска","Мексиканска"};
        for (String c : arrCuisinez){
            cuisinez.addElement(c);
        }
        cmbFilter.setModel(cuisinez);

//zad2
        tableModel = new DefaultTableModel(
                new Object[]{"Име", "Кухня", "Съставка", "Минути"}, 0) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
tblItems.setModel(tableModel);

listModel = new DefaultListModel<>();
lstItems.setModel(listModel);

items.add(new Recipe("Таратор", "Българска", "краставици", 15));
items.add(new Recipe("Карбонара", "Италианска", "паста", 25));
items.add(new Recipe("Пад тай", "Азиатска", "оризови нудли", 30));


ApplyFilter();

cmbCuisine.addItem( "Българска"  );
    cmbCuisine.addItem("Италианска");
        cmbCuisine.addItem("Азиатска");
            cmbCuisine.addItem("Мексиканска");

            setLocationRelativeTo(null);
        
    }
    private void setStatus(String text){
        lblStatus.setText(text);
        statusTimer.restart();
    }
private void ApplyFilter(){
String selected = (String) cmbFilter.getSelectedItem();
List<Recipe> result = new ArrayList<>();
for(Recipe r : items){
    if("Всички".equals(selected)|| r.getCuisine().equals(selected)){
        result.add(r);
    }
}
show(result);
lblStatus.setText("Показани: " +result.size()+" from " + items.size());
}

    
public void show(List<Recipe> data) {
  shown=data;
    tableModel.setRowCount(0);
    listModel.clear();

    for (Recipe r : data) {
        tableModel.addRow(new Object[]{
            r.getName(),
            r.getCuisine(),
            r.getMainIngredient(),
            r.getMinutes()
        });

        listModel.addElement(r);
    }

    lblStatus.setText("Показани: " + data.size());
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFilter = new javax.swing.JPanel();
        lblFilter = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox<>();
        scrItems = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        scrList = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<>();
        pnlBottom = new javax.swing.JPanel();
        pnlFields = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCuisine = new javax.swing.JLabel();
        cmbCuisine = new javax.swing.JComboBox<>();
        lblMainIngredient = new javax.swing.JLabel();
        txtMainIngredient = new javax.swing.JTextField();
        lblMinutes = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JTextField();
        pnlButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Контролна работа 1 — Рецепти");

        pnlFilter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblFilter.setText("Филтър:");
        pnlFilter.add(lblFilter);

        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });
        pnlFilter.add(cmbFilter);

        getContentPane().add(pnlFilter, java.awt.BorderLayout.NORTH);

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrItems.setViewportView(tblItems);

        getContentPane().add(scrItems, java.awt.BorderLayout.CENTER);

        scrList.setPreferredSize(new java.awt.Dimension(240, 100));

        lstItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrList.setViewportView(lstItems);

        getContentPane().add(scrList, java.awt.BorderLayout.EAST);

        pnlBottom.setLayout(new java.awt.BorderLayout());

        pnlFields.setLayout(new java.awt.GridLayout(4, 2, 6, 6));

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Име:");
        pnlFields.add(lblName);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        pnlFields.add(txtName);

        lblCuisine.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCuisine.setText("Кухня:");
        pnlFields.add(lblCuisine);
        pnlFields.add(cmbCuisine);

        lblMainIngredient.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMainIngredient.setText("Основна съставка:");
        pnlFields.add(lblMainIngredient);
        pnlFields.add(txtMainIngredient);

        lblMinutes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinutes.setText("Минути:");
        pnlFields.add(lblMinutes);
        pnlFields.add(txtMinutes);

        pnlBottom.add(pnlFields, java.awt.BorderLayout.NORTH);

        pnlButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAdd.setText("Добави");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlButtons.add(btnAdd);

        btnDelete.setText("Изтрий");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDelete);

        pnlBottom.add(pnlButtons, java.awt.BorderLayout.CENTER);

        lblStatus.setText("Готово.");
        pnlBottom.add(lblStatus, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(459, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
String name = txtName.getText().trim();
String ingredient = txtMainIngredient.getText().trim();
 String cuisine = (String) cmbCuisine.getSelectedItem();

if(name.isBlank()||ingredient.isBlank()){
JOptionPane.showMessageDialog(this,"Име и Съставка са задължителни","Грешка",JOptionPane.WARNING_MESSAGE);    
return;}
int minutes;
try{
   minutes = Integer.parseInt(txtMinutes.getText().trim()); 
} catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(this, "не е число", "Error", JOptionPane.WARNING_MESSAGE);
return;}
if(minutes <= 0){
     JOptionPane.showMessageDialog(this, "числото трябва да е по голямо от нула", "Error", JOptionPane.WARNING_MESSAGE);
    return;
}
Recipe r = new Recipe(name,cuisine,ingredient,minutes);
items.add(r);
ApplyFilter();
txtName.setText("");
txtMainIngredient.setText("");
txtMinutes.setText("");
setStatus("Добавен: " + r);
// TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
ApplyFilter();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFilterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      int row = tblItems.getSelectedRow();
      if(row == -1)
      {
          lblStatus.setText("Markirayte red");return;
      }
      Recipe r = shown.get(row);
      int answer = JOptionPane.showConfirmDialog(this,"Da se iztrie li" + r + "?","Deleting",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      if(answer==JOptionPane.YES_OPTION){
          items.remove(r);
         ApplyFilter();
     setStatus("Изтрит: " + r); }

// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static void main(String[] args) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> new MainForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cmbCuisine;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JLabel lblCuisine;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblMainIngredient;
    private javax.swing.JLabel lblMinutes;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<Recipe> lstItems;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlFields;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JScrollPane scrItems;
    private javax.swing.JScrollPane scrList;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtMainIngredient;
    private javax.swing.JTextField txtMinutes;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
