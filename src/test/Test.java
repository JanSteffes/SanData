package test;

import data.Config;
import data.packages.implementations.PackageData.PackageDataListFiles;
import data.packages.implementations.PackageData.PackageDataListFolders;
import data.packages.implementations.PackageDataUpdate;
import data.packages.implementations.PackageData.PackageDataUpdateCheck;
import data.packages.implementations.WriteListener.StreamListener;
import data.packages.interfaces.IStreamListener;

public class Test {
    public static void main(String[] args)
    {
        //Config.switchDebug();
        IStreamListener streamListener = new StreamListener();
        //ListTest(null);
        //ListTest(streamListener);
        ListFilesTest(null, null);

//        ArrayList<String> mergeList = new ArrayList<String>();
//        mergeList.add("Seite1.pdf");
//        mergeList.add("Lorem ipsum dolor sit amet.pdf");
//        PackageDataMerge testMerge = new PackageDataMerge("test", mergeList);
//        boolean mergeResult = testMerge.Execute();
//        System.out.println("Mergeresult: " + mergeResult);

//       ArrayList<String> deleteList = new ArrayList<String>();
//        deleteList.add("testtestetststetsts.pdf");
//        deleteList.add("testtestetststetststsstetstetstsgststs.pdf");
//        PackageDataDelete delete = new PackageDataDelete(deleteList);
//        boolean deleteResult = delete.Execute();
//        System.out.println("DeleteResult: " + deleteResult);

        //UpdateTest("1.0.0");
        //UpdateTest("2.0.0");
        //UpdateTest("1.1.0");
        //UpdateTest("0.1.0");
        //UpdateTest("0.0.1");
        //UpdateTest("2.5.1", streamListener);
        //UpdateTest("1.0.2", streamListener, true);


    }

    private static void ListTest(IStreamListener streamListener)
    {
        String[] folders = ListFoldersTest(streamListener);
        String firstFolder = folders[folders.length-1];
        ListFilesTest(firstFolder, streamListener);
    }

    private static String[] ListFoldersTest(IStreamListener streamListener)
    {
        PackageDataListFolders test = new PackageDataListFolders();
        String[] result = test.Execute(streamListener);
        System.out.println("Executed: " + String.join(", ", result));
        return result;
    }

    private static void ListFilesTest(String folderName, IStreamListener streamListener)
    {
        PackageDataListFiles test = new PackageDataListFiles(folderName);
        String[] result = test.Execute(streamListener);
        System.out.println("Executed for folder '" + folderName + "': " + String.join(", ", result));
    }

    private static void UpdateTest(String version, IStreamListener streamListener, boolean tryUpdate)
    {
        System.out.println("Testing update for version " + version);
        PackageDataUpdateCheck checkForUpdate = new PackageDataUpdateCheck(version);
        boolean updateNeeded = checkForUpdate.Execute(streamListener);
        if (updateNeeded) {
            System.out.println("Update needed!");
            if (tryUpdate) {
                PackageDataUpdate testUpdate = new PackageDataUpdate(version);
                byte[] result = testUpdate.Execute(streamListener);
                if (result == null) {
                    System.out.println("No update needed! (returned null)");
                } else {
                    System.out.println("UpdateResultBytes: " + result.length);
                }
                System.out.println(" ");
            }
        }
        else
        {
            System.out.println("No update needed!");
        }
    }
}
