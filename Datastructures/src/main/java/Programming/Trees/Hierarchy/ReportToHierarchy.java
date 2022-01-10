package Programming.Trees.Hierarchy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportToHierarchy {
    static Map<Integer, EmployeeNode> employees;
    static EmployeeNode root;

    public static void main(String[] args) throws IOException {
        employees = new HashMap<>();
        readDataAndCreateMap();
        buildHierarchyTree(root);
        printHierarchyTree(root, 0);
    }

    private static void readDataAndCreateMap() {
    try {
      FileReader fin = new FileReader("C:\\Users\\Ken\\Desktop\\DataStructures\\Datastructures\\src\\main\\java\\Programming\\input-employee.txt");
            BufferedReader br = new BufferedReader(fin);

            String strLine;
            EmployeeNode employee = null;

            while ((strLine = br.readLine()) != null) {
                String[] values = strLine.split(" ");
                try {
                    if (values.length > 1) {
                        employee = new EmployeeNode(values[0], values[1] + " " + values[2], values[3]);
                    }
                } catch (Exception e) {
                    employee = new EmployeeNode(values[0], values[1] + " " + values[2], "0");
                }
                assert employee != null;
                employees.put(employee.getId(), employee);
                if (employee.getReportToId() == 0) {
                    root = employee;
                }
            }
            fin.close();
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }
    //scan whole employee hashMap to form a list of subordinates for the given id
    private static List<EmployeeNode> getSubordinatesById(int rid) {
        List<EmployeeNode> subordinates = new ArrayList<>();
        for (EmployeeNode e : employees.values()) {
            if (e.getReportToId() == rid) {
                subordinates.add(e);
            }
        }
        return subordinates;
    }
    //build tree recursively
    private static void buildHierarchyTree(EmployeeNode localRoot) {
        List<EmployeeNode> subordinates = getSubordinatesById(localRoot.getId());
        localRoot.setSubordinates(subordinates);
        if (subordinates.size() == 0) {
            return;
        }
        for (EmployeeNode e : subordinates) {
            buildHierarchyTree(e);
        }
    }
    //print tree recursively
    private static void printHierarchyTree(EmployeeNode localRoot, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(localRoot.getName());

        List<EmployeeNode> subordinates = localRoot.getSubordinates();
        System.out.print(" ");
        for (EmployeeNode e : subordinates) {
            printHierarchyTree(e, level + 1);
        }
    }
}
class EmployeeNode {
    int empId;
    String name;
    int reportToId;
    List<EmployeeNode> subordinates;

    public EmployeeNode(String id,  String empName, String rid) {
        try {
            this.empId = Integer.parseInt(id);
            this.name = empName;
            this.reportToId = Integer.parseInt(rid);
        }  catch (Exception e) {
            System.err.println("Exception creating employee:" + e);
        }
    }

    List<EmployeeNode> getSubordinates() {
        return subordinates;
    }

    void setSubordinates(List<EmployeeNode> subordinates) {
        this.subordinates = subordinates;
    }

    int getId() {
        return empId;
    }

    String getName() {
        return name;
    }

    int getReportToId() {
        return reportToId;
    }
}