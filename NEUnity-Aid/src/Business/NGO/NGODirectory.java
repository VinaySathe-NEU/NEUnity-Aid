/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.NGO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinaysathe
 */
public class NGODirectory {
    
  List<NGO> ngoList;
    private static NGODirectory ngodirectory;
    
    public static NGODirectory getInstance(){
       
        if(ngodirectory==null){
            ngodirectory=new NGODirectory();
        }
        return ngodirectory;  
    }

    public List<NGO> getNGOList() {
        return ngoList;
    }

    public void setNGOList(List<NGO> ngoList) {
        this.ngoList = ngoList;
    }
    
    
    public NGODirectory() {
        ngoList = new ArrayList<NGO>();
    }
    
    public NGO addNGO(){
     NGO ngo = new NGO();
        ngoList.add(ngo);
      return ngo;
    }
        
}
