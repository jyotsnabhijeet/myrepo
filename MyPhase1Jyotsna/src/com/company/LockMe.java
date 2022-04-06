 package com.company;
import java.io.File;
import java.util.*;
import java.io.FileWriter;


public class LockMe {
	static File folder = new File("D:\\project1");
	static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
	public static void main(String[] args) {
		boolean bExit= false;
		Integer iResponse = 0;
		while(!bExit)
		{
			menu();
			
			try {
				iResponse= Integer.parseInt(scanner.nextLine());
				PrintMessage(">selected:" +iResponse);
				switch(iResponse) {
				case 1:{
					Random random = new Random();
					int rn = random.nextInt() + 1;
					
					switch(rn) {
					case 1: 
						getAllFiles_forLoop();
						break;
						
						case 2 :
							getAllFiles_while();
							break;
						
						case 3 :
							getAllFiles_forEachLoop();
							break;
						
						case 4 :
							getAllFiles_Iterator();
							break;
							
						case 5 :
							getAllFiles_LambdaExpression();
							break;
						
						case 6 :
							getAllFiles_EnumerationInterface();
							break;
						
					}
					break;
				}
				case 2:
				{
					createFile(scanner);
					break;
				}
				case 3 :
				{
					deleteFile(scanner);
					break;
				}
				case 4 :
				{
					searchFiles(scanner);
					break;
				}
				case 5 :
				{
					bExit =true;	
					break;
				}
				default :
				{
					bExit =true;
					
				}
			}
				
		}
			
			catch (NumberFormatException e)
			{
				PrintMessage("Print only Numbers");
			}
		}
					
	}			
		public static void getAllFiles_forLoop()
		{
			File[] listOfFiles = folder.listFiles();
			List<File> alListOfFiles = new ArrayList<File>();
			Collections.addAll(alListOfFiles, listOfFiles);
			
			try
			{
				for(int i=0; i<alListOfFiles.size(); i++)
						System.out.println(alListOfFiles.get(i));
			}
		
				catch(Exception e) 
				{
					PrintMessage("Error : File nopt found");
			
		}
			
	}
	
		public static void getAllFiles_while()
		{
			File[] listOfFiles = folder.listFiles();
			LinkedList<File> llListOfFiles = new LinkedList<File>() ;
			Collections.addAll(llListOfFiles, listOfFiles);
			int counter = 0;
			while(llListOfFiles.size()>counter) {
				System.out.println(llListOfFiles.get(counter));
				counter++;
				
			}
		
		}				
			public static void getAllFiles_forEachLoop()
			{
				File[] listOfFiles = folder.listFiles();
				for(File myFile : listOfFiles) {
					System.out.println(myFile.getName());
				}
			}
			
				
			 public static void getAllFiles_LambdaExpression()
			 {
				 File[] listOfFiles = folder.listFiles();
				 List<File> alListOfFiles = new ArrayList<>();
				 Collections.addAll(alListOfFiles, listOfFiles);
				 alListOfFiles.forEach((file)-> {
				 
					System.out.println(file.getName());
				 });
				 
			 }
			 public static void getAllFiles_EnumerationInterface()
			 {
				 File [] listOfFiles = folder.listFiles();
				 List<File> alListOfFiles = new ArrayList<>();
				 Collections.addAll(alListOfFiles, listOfFiles);
				 Enumeration<File> e = Collections.enumeration(alListOfFiles);
				 while(e.hasMoreElements()) {
					 System.out.println(e.nextElement().getName());
				 }
				 
				 }
			 public static void getAllFiles_Iterator() {
				 File[] listOfFiles = folder.listFiles();
				 List<File> alListOfFiles = new	ArrayList<File>();
				 Collections.addAll(alListOfFiles, listOfFiles);
				 LinkedList<File> llListOfFiles = new LinkedList<>(alListOfFiles);
				 try {
					 Iterator<File>alListOfFilesIterator = llListOfFiles.iterator();
					 while(alListOfFilesIterator.hasNext()) {
						 System.out.println(alListOfFilesIterator.next());
						 
					 }
				 }
				 catch(Exception e)
				 {
					 PrintMessage("Error File Not found");
				 }
				 
				}
		public static void deleteFile(Scanner scannerdelete)
		{
			try
			{
				System.out.println("Write the name of the file you want to delete");
				File fileToDelete = new File(folder + "//" + scannerdelete.nextLine());
					if(fileToDelete.delete())
					{
						PrintMessage("File Deleted Successfully");
						
					}
					else {
						PrintMessage("There was an error deleting the file");
						
					}
		}
			catch(Exception e) {
				PrintMessage("There was an error deleting the file");
			}
		}
			public static void searchFiles(Scanner scannersearch)
			{
				try
				{
					System.out.println("Write the name of file to you want to search");
					File fileToFind = new File(folder + "//" + scannersearch.nextLine());
					if(fileToFind.exists()) 
					{
						PrintMessage("File Exists");
						
					}
					else 
					{
						PrintMessage("File Does not Exist");
						
					}
				}
				catch(Exception e) 
				{
					PrintMessage("There was an error while searching this file");
				}
			}
				public static void createFile(Scanner scannerCreate) 
				{
					FileWriter writer = null;
					try 
					{
						System.out.println("What is the name of your file");
						File newFile = new File(folder + "//" + scannerCreate.nextLine());
						writer = new FileWriter(newFile);
						System.out.println("And the contentes of your file are....");
						writer.write(scannerCreate.nextLine());
						writer.close();
						PrintMessage("File created successfully");						
						
					}
					catch(Exception ex){
						ex.printStackTrace();
					}	
				}
				public static void menu() {
					System.out.println("\n");
					System.out.println("**************************************************");
					System.out.println("************Welcome TO LockMe.com**************");
					System.out.println("**************Designed By :- Jyotsna Kulkarni *********************");
					System.out.println("1) Display all the files");
					System.out.println("2) Add a new file");
					System.out.println("3) Delete a file");
					System.out.println("4) Search a file");
					System.out.println("5) Exit");
					System.out.println("");
					System.out.println("> Select an option...");
							
				}	
			public static void PrintMessage( String message)
			 {
			System.out.println("--------------------------------");
			System.out.println("" + message);
			System.out.println("--------------------------------");
			 }
		

		}