package test;

import data.packages.implementations.PackageData.PackageDataDelete;
import data.packages.implementations.PackageData.PackageDataListFiles;
import data.packages.implementations.PackageData.PackageDataListFolders;
import data.packages.implementations.PackageDataUpdate;
import data.packages.implementations.PackageData.PackageDataUpdateCheck;
import data.packages.implementations.WriteListener.StreamListener;
import data.packages.interfaces.IStreamListener;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args)
    {
        //Config.switchDebug();
        IStreamListener streamListener = new StreamListener();
        //ListTest(null);
        //ListTest(streamListener);
        listFilesTest(null, null);
        deleteTest(streamListener, "test.pdf", null);

//        ArrayList<String> mergeList = new ArrayList<String>();
//        mergeList.add("Seite1.pdf");
//        mergeList.add("Lorem ipsum dolor sit amet.pdf");
//        PackageDataMerge testMerge = new PackageDataMerge("test", mergeList);
//        boolean mergeResult = testMerge.Execute();
//        System.out.println("Mergeresult: " + mergeResult);

        //UpdateTest("1.0.0");
        //UpdateTest("2.0.0");
        //UpdateTest("1.1.0");
        //UpdateTest("0.1.0");
        //UpdateTest("0.0.1");
        //UpdateTest("2.5.1", streamListener);
        //UpdateTest("1.0.2", streamListener, true);


    }

    private static boolean deleteTest(IStreamListener streamListener, String fileName, String folderName)
    {
        if (folderName == null) {
            folderName = getLatestFolder(streamListener);
        }
        PackageDataDelete test = new PackageDataDelete(folderName, new ArrayList<>(Collections.singleton(fileName)));
        boolean result = test.execute(streamListener);
        return result;
    }

    private static void listTest(IStreamListener streamListener)
    {
        String firstFolder = getLatestFolder(streamListener);
        listFilesTest(firstFolder, streamListener);
    }

    private static String getLatestFolder(IStreamListener streamListener) {
        String[] folders = listFoldersTest(streamListener);
        return folders[folders.length - 1];
    }

    private static String[] listFoldersTest(IStreamListener streamListener)
    {
        PackageDataListFolders test = new PackageDataListFolders();
        String[] result = test.execute(streamListener);
        System.out.println("Executed: " + String.join(", ", result));
        return result;
    }

    private static void listFilesTest(String folderName, IStreamListener streamListener)
    {
        PackageDataListFiles test = new PackageDataListFiles(folderName);
        String[] result = test.execute(streamListener);
        System.out.println("Executed for folder '" + folderName + "': " + String.join(", ", result));
    }

    private static void updateTest(String version, IStreamListener streamListener, boolean tryUpdate)
    {
        System.out.println("Testing update for version " + version);
        PackageDataUpdateCheck checkForUpdate = new PackageDataUpdateCheck(version);
        boolean updateNeeded = checkForUpdate.execute(streamListener);
        if (updateNeeded) {
            System.out.println("Update needed!");
            if (tryUpdate) {
                PackageDataUpdate testUpdate = new PackageDataUpdate(version);
                byte[] result = testUpdate.execute(streamListener);
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
