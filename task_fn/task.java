package task_fn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task {

    public static void main(String[] args) {
        Set<ntBook> nbSet = defaultSetNoteBooks();
        System.out.println("Full notebook list.");
        for (ntBook nb : nbSet) {
            System.out.println(nb.noteBookCard());
        }

        Scanner scanner = new Scanner(System.in);
        String buff;
        boolean valid = true;
        int min_ram = 0;
        int min_hdd = 0;
        String cur_os = "";
        String cur_color = "";
        while(true)
        {
            System.out.printf("Enter number to choose necessary section option or \"/return\" to exit the program:\n1 - RAM\n2 - SSD/HDD size\n3 - Opeation System\n4 - Color\nYour number is: ");
            switch(scanner.nextLine())
            {
                case "1":
                    System.out.printf("Enter minimal RAM in Gb, \"/break\" to return to the previous menu \"/return\" to exit the program: ");
                    valid = true;
                    while (valid)
                    {
                        buff = scanner.nextLine();
                        switch(buff)
                        {
                            case "/return":
                                System.out.println("Program finished!");
                                scanner.close();
                                return;
                            case "/break":
                                System.out.println("To the previous menu!");
                                valid = false;
                                break;
                            default:
                                try{
                                    min_ram = Integer.parseInt(buff);
                                    valid = false;
                                }
                                catch (NumberFormatException ex){
                                    System.out.printf("Invalid value was entered! Try again: ");
                                }
                                
                        }
                    }
                    break;
                case "2":
                    System.out.printf("Enter minimal HDD/SSD memory size in Gb, \"/break\" to return to the previous menu \"/return\" to exit the program: ");
                    valid = true;
                    while (valid)
                    {
                        buff = scanner.nextLine();
                        switch(buff)
                        {
                            case "/return":
                                System.out.println("Program finished!");
                                scanner.close();
                                return;
                            case "/break":
                                System.out.println("To the previous menu!");
                                valid = false;
                                break;
                            default:
                                try{
                                    min_hdd = Integer.parseInt(buff);
                                    valid = false;
                                }
                                catch (NumberFormatException ex){
                                    System.out.printf("Invalid value was entered! Try again: ");
                                }
                                
                        }
                    }
                    break;
                case "3":
                    System.out.println("Enter notebook operation system, \"/break\" to return to the previous menu \"/return\" to exit the program: ");
                    System.out.printf("Windows Vista\tWindows 8\tUbuntu\nWindows XP\tWindows 8.1\tDebian\nWindows 7\tWindows 8\tArch Linux\nOther\nYour OS is: ");

                    buff = scanner.nextLine();
                    switch(buff)
                    {
                        case "/return":
                            System.out.println("Program finished!");
                            scanner.close();
                            return;
                        case "/break":
                            System.out.println("To the previous menu!");
                            valid = false;
                            break;
                        case "Windows Vista":
                        case "Windows XP":
                        case "Windows 7":
                        case "Windows 8":
                        case "Windows 8.1":
                        case "Windows 10":
                        case "Ubuntu":
                        case "Debian":
                        case "Arch Linux":
                            cur_os = buff;
                            break;
                        case "Other":
                            cur_os = "unknown";
                            break;
                        default:
                            System.out.println("No such operation system in list");
                            cur_os= "";
                    }
                    break;
                case "4":
                    System.out.println("Enter notebook color, \"/break\" to return to the previous menu \"/return\" to exit the program: ");
                    System.out.printf("grey\tblack\tsilver\nYour color is: ");

                    buff = scanner.nextLine();
                    switch(buff)
                    {
                        case "/return":
                            System.out.println("Program finished!");
                            scanner.close();
                            return;
                        case "/break":
                            System.out.println("To the previous menu!");
                            valid = false;
                            break;
                        case "grey":
                        case "black":
                        case "silver":
                            cur_color = buff;
                            break;
                        default:
                            System.out.println("No such color in list");
                            cur_color = "";
                    }
                    break;
                case "/return":
                    System.out.println("Program finished!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Section with such number doesn't exist.");
            }
            System.out.println();
            System.out.println("Choosen parameters: ");
            System.out.printf("\tMinimal RAM: ");
            System.out.println(min_ram);
            System.out.printf("\tMinimal HDD/SSD size: ");
            System.out.println(min_hdd);
            System.out.printf("\tOS: ");
            System.out.println(cur_os);
            System.out.printf("\tColor: ");
            System.out.println(cur_color);
            System.out.println();

            System.out.println("Filtered variants: ");
            for (ntBook nb : nbSet) {
                if (nb.getRAM() >= min_ram)
                    if (nb.getMem() >= min_hdd)
                        if ((cur_os.equals("")) || (nb.getOS().equals(cur_os)))
                            if ((cur_color.equals("")) || (nb.getColor().equals(cur_color)))
                                System.out.println(nb.noteBookCard());
            }

            System.out.println();
            
        }


        
    }
    
    public static Set<ntBook> defaultSetNoteBooks()
    {
        Set<ntBook> curNbSet = new HashSet<ntBook>();
        curNbSet.add(new ntBook("AORUS 5 KE4", 16, 1000, "black", "Windows 10"));
        curNbSet.add(new ntBook("ASUS N750JV", 8, 750, "grey", "Ubuntu"));
        curNbSet.add(new ntBook("MSI Vector GP76 12UGSO-858XRU", 16, 1000, "black", "Kali Linux"));
        curNbSet.add(new ntBook("GIGABYTE G5 GE", 16, 512, "black", "Debian"));
        curNbSet.add(new ntBook("MSI GF76 Katana 11UE-269XRU", 16, 512, "black", "Arch Linux"));
        curNbSet.add(new ntBook("HUAWEI MateBook D16 RLEF-X", 16, 512, "grey", "Windows 10"));
        curNbSet.add(new ntBook("HP Laptop 15s-fq2128ur", 8, 256, "silver", "Ubuntu"));
        curNbSet.add(new ntBook("Honor MagicBook X14 NobelBR-WAI9B", 8, 256, "grey", "Windows 10"));
        curNbSet.add(new ntBook("Lenovo IdeaPad 3 15ITL6", 8, 1000, "silver", "Ubuntu"));
        curNbSet.add(new ntBook("MSI Modern 14 C12M-230RU", 8, 512, "black", "Windows 10"));

        return curNbSet;
    }


}