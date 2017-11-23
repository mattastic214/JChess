package edu.uwrf.segroup.drivers;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

import edu.uwrf.segroup.model.Model;

public class Controller implements MouseListener, ButtonModel {
	
	Model model;
	View view;
	
	public Controller() {
		System.out.println("Controller()");
	}
	
	public void addModel(Model m) {
		System.out.println("Controller: adding model");
		this.model = m;
	}
	
	public void addView(View v) {
		System.out.println("Controller: adding view");
		this.view = v;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getSelectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemListener(ItemListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getActionCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMnemonic() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isArmed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRollover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemListener(ItemListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionCommand(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setArmed(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGroup(ButtonGroup group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMnemonic(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPressed(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRollover(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
