
package com.Jessy;

        import javax.swing.*;
        import javax.swing.event.ListSelectionEvent;
        import javax.swing.event.ListSelectionListener;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.ComponentAdapter;
        import java.awt.event.FocusAdapter;
        import java.util.Date;
        import java.util.LinkedList;

/**
 * Created by Jessy on 11/21/2015.
 */
public class HvacGUI extends JFrame{

    // Creating LinkedList resolvedServiceCall and serviceCallQueue
    LinkedList<ServiceCall> resolvedServiceCall = new LinkedList<>();
    LinkedList<ServiceCall> serviceCallQueue = new LinkedList<>();


    private JButton addServiceCallButton;
    private JTextField textFieldAddress;
    private JTextField textFieldDescription;
    private JTextField textFieldModelAC;
    private JPanel rootPanel;
    private JList listServiceCall;
    private JRadioButton furnaceServiceRadioButton;
    private JRadioButton centralACServiceRadioButton;
    private JLabel labelAC;
    private JLabel labelFurnace;
    private JTextField textFieldFurnaceType;
    private JLabel labelForcedAir;
    private JLabel labelBoiler;
    private JLabel labelOctopus;
    private JTextField textFieldResolution;
    private JButton deleteServiceCallButton;
    private JLabel resolutionLabel;


    private ButtonGroup decision;

    // Declaring serviceCallListModel
    DefaultListModel<ServiceCall> serviceCallDefaultListModel;


    // Declaring Date variable reportedDate
    public Date reportedDate;
    public int fee = 0;



    // HvacGUI method starts here
    public HvacGUI(){


        super("HVAC Service Call Information");  // Display for the title

        setContentPane(rootPanel);  //  setting the JPanel called "rootPanel" to JFrame


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // setting the default close operation on JFrame
        setVisible(true);// make the form visible
        setSize(new Dimension(400, 400));   // setting the form size



        // creating a serviceCallDefaultListModel for the DefaultListModel
        // Creating a basic set up and function for a JList
        serviceCallDefaultListModel = new DefaultListModel<ServiceCall>();
        listServiceCall.setModel(serviceCallDefaultListModel);

        // Change list selection mode to single selection
        listServiceCall.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        // Making the radio button CentralAC Service and Furnace Service a ButtonGroup,
        // so that only one radio button can be selected
        decision = new ButtonGroup();
        decision.add(centralACServiceRadioButton);
        decision.add(furnaceServiceRadioButton);


        //set Ac as default
        centralACServiceRadioButton.setSelected(true);
        textFieldModelAC.setVisible(true);
        labelAC.setVisible(true);

        // Setting the default visibility
        textFieldFurnaceType.setVisible(false);
        labelFurnace.setVisible(false);
        labelForcedAir.setVisible(false);
        labelBoiler.setVisible(false);
        labelOctopus.setVisible(false);
        resolutionLabel.setVisible(false);
        textFieldResolution.setVisible(false);
        listServiceCall.setVisible(false);



        // ActionListener is listening to any change on centralAC radio button
        centralACServiceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if centralAC radio button is selected, set the visibility for the property
                if (centralACServiceRadioButton.isSelected()) {

                    textFieldModelAC.setVisible(true);
                    labelAC.setVisible(true);

                    textFieldFurnaceType.setVisible(false);
                    labelFurnace.setVisible(false);
                    labelForcedAir.setVisible(false);
                    labelBoiler.setVisible(false);
                    labelOctopus.setVisible(false);

                }

            }
        });


        // ActionListener is listening to any change on furnace radio button
        furnaceServiceRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if furnace radio button is selected, set the visibility for the property
                if (furnaceServiceRadioButton.isSelected()) {

                    textFieldModelAC.setVisible(false);
                    labelAC.setVisible(false);

                    textFieldFurnaceType.setVisible(true);
                    labelFurnace.setVisible(true);
                    labelForcedAir.setVisible(true);
                    labelBoiler.setVisible(true);
                    labelOctopus.setVisible(true);
                }
            }
        });



        // ActionListener is listening to any change on addServiceCall button
        addServiceCallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                // getting the user input for address and description
                String address = textFieldAddress.getText();
                String description = textFieldDescription.getText();
                reportedDate = new Date();

                // if centralAC radio button is selected, get the user input for the modelAC and call the centralAC
                // constructor and add the centralAC object data in to a Linked List serviceCallQueue
                if (centralACServiceRadioButton.isSelected()) {
                    String modelAC = textFieldModelAC.getText();
                    CentralAC centralACService = new CentralAC(address, description, reportedDate, modelAC);
                    serviceCallQueue.add(centralACService);

                    // display the centralAC object data in the list
                    serviceCallDefaultListModel.addElement(centralACService);



                    // if centralAC radio button is selected, get the user input for the furnaceType
                } else if (furnaceServiceRadioButton.isSelected()) {
                    String furnaceType = textFieldFurnaceType.getText();


                    // Validation for the user input on the furnaceType variable
                    // making sure the data input was a integer of 1, 2 or 3
                    try {
                        int type = Integer.parseInt(furnaceType);

                        if (type >= 1 && type <=3){


                            // if the furnaceType data was valid data, call the constructor for the Furnace object
                            // and add the furnace object data in to a Linked List serviceCallQueue
                            Furnace furnaceService = new Furnace(address, description, reportedDate, type);


                            serviceCallQueue.add(furnaceService);


                            // adding furnaceService data to the JList
                            serviceCallDefaultListModel.addElement(furnaceService);
                        }

                        // if the data was not a valid data, display a  dialog box message
                        else {
                            JOptionPane.showMessageDialog(HvacGUI.this, "Furnace type must be an integer value between 1 and 3");
                        }
                    } catch
                            (NumberFormatException j) {
                        JOptionPane.showMessageDialog(HvacGUI.this,"Entry Error... Please enter a integer value for a furnace type again.");

                    }
                }


                        // clearing the text box for new input data
                        textFieldDescription.setText("");
                        textFieldAddress.setText("");
                        textFieldModelAC.setText("");
                        textFieldFurnaceType.setText("");

                        listServiceCall.setVisible(true);


                    }
                });



                // ActionListener is listening to any change on deleteServiceCall button
                deleteServiceCallButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // if data selection was made from the List and if the resolved text box is empty,
                        // show a message "Please enter a resolution"
                        if (!listServiceCall.isSelectionEmpty()) {

                            if (textFieldResolution.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(HvacGUI.this, "Please enter a resolution");


                                //  get user input from resolved text box
                            } else {
                                String resolvedMethod = textFieldResolution.getText();
                                Date resolvedNow = new Date();  // set resolvedNow date

                                // getting the value of the selected data from the list and store it in "toDelete"
                                ServiceCall toDelete = (ServiceCall) listServiceCall.getSelectedValue();


                                // remove the toDelete value from the JList
                                HvacGUI.this.serviceCallDefaultListModel.removeElement(toDelete);
                                serviceCallQueue.remove(toDelete);  // remove toDelete from serviceCallQueue
                                String fee = JOptionPane.showInputDialog("Please enter the fee charged");
                                double fees = Double.parseDouble(fee);
                                toDelete.setFee(fees);


                                    // Calling a method to construct the resolution and resolutionDate
                                    toDelete.setResolution(resolvedMethod);
                                    toDelete.setResolvedDate(resolvedNow);

                                    resolvedServiceCall.add(toDelete);  // adding the toDelete value date to resolvedServiceCall
                                    textFieldResolution.setText("");  // clear the text box

                                    JOptionPane.showMessageDialog(HvacGUI.this, "Service Call successfully resolved " + toDelete);


                                }

                                // if ticket data is not selected from JList, show message " Please select a Service Call to delete"
                            }else{
                                JOptionPane.showMessageDialog(HvacGUI.this, "Please select a Service Call to delete");

                            }

                        }
                    }

                    );

                    listServiceCall.addListSelectionListener(new ListSelectionListener() {
                        @Override
                         public void valueChanged(ListSelectionEvent e) {
                             resolutionLabel.setVisible(true);
                             textFieldResolution.setVisible(true);
                         }
                         }

                    );
                }

    }
