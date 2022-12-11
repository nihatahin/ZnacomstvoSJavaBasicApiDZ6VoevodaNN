package task_fn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ntBook {
    String model;
    int ramGb;
    int hddMemGb;
    String operSys;
    String color;

    String[] os_arr = {"Windows Vista", "Windows XP", "Windows 7", "Windows 8", "Windows 8.1", "Windows 10", "Ubuntu", "Debian", "Arch Linux"};
    Set<String> osCol = new HashSet<String>(Arrays.asList(os_arr));
    

    ntBook (String name, int ram, int hdd, String clr, String os){
        model = name;
        ramGb = ram;
        hddMemGb = hdd;
        if (osCol.contains(os))
            operSys = os;
        else
            operSys = "unknown";
        color = clr;
    }


    //@Override
    public String noteBookCard() {
        
        return String.format("Model: %s\nRAM: %d\nIntire memory: %d\nOS: %s\nColor: %s\n//----------", model, ramGb, hddMemGb, operSys, color);
    }

    public String osSetCard() {
        
        return String.format("Model: %s\nRAM: %d\nIntire memory: %d\nOS: %s\nColor: %s\n//----------", model, ramGb, hddMemGb, operSys, color);
    }

    public String getOS(){
        return operSys;
    }

    public String getColor(){
        return color;
    }

    public int getRAM(){
        return ramGb;
    }

    public int getMem(){
        return hddMemGb;
    }

}
