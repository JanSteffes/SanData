package test;

import data.packages.implementations.PackageDataDelete;
import data.packages.implementations.PackageDataList;
import data.packages.implementations.PackageDataMerge;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args)
    {
//       PackageDataList test = new PackageDataList();
//       String[] result = test.Execute();
//        System.out.println("Executed: " + String.join(", ", result));

//        ArrayList<String> mergeList = new ArrayList<String>();
//        mergeList.add("Seite1.pdf");
//        mergeList.add("Lorem ipsum dolor sit amet.pdf");
//        PackageDataMerge testMerge = new PackageDataMerge("test", mergeList);
//        boolean mergeResult = testMerge.Execute();
//        System.out.println("Mergeresult: " + mergeResult);

       ArrayList<String> deleteList = new ArrayList<String>();
        deleteList.add("testtestetststetsts.pdf");
        deleteList.add("testtestetststetststsstetstetstsgststs.pdf");
        PackageDataDelete delete = new PackageDataDelete(deleteList);
        boolean deleteResult = delete.Execute();
        System.out.println("DeleteResult: " + deleteResult);

    }
}
