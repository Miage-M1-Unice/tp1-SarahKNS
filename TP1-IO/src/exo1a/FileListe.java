package exo1a;
import java.io.File;
import java.io.FilenameFilter;

public class FileListe {

	public static void main(String[] args) {
		//	FileListe p1 = new FileListe();
		//	p1.pathListe();

		FileListe f1 = new FileListe();

		File f = new File("C:/Program Files/mosquitto");
		//f1.recursiveListe(f);

		f1.lsFilter2(f);
	}

	private void pathListe() {
		File f = null;
		File[] paths;

		try {  
			f = new File(".");
			paths = f.listFiles();

			for(File path:paths) {
				System.out.println(path);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void recursiveListe(File f) {
		//File f = new File(".");

		if(f.isDirectory()){

			File[] f1 = f.listFiles();

			for(File child:f1){
				print(child);
				if (child.isDirectory()) {
					recursiveListe(child);
				}


				try {						
					System.out.println(f.getCanonicalPath());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	//classe anonyme interne embarquee
	private void lsFilter(File dir) {
		File[] paths;

		// File t = new 	File(".");
		FilenameFilter t1 = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.lastIndexOf('.')>0) {

					int lastIndex = name.lastIndexOf('.');
					String str =name.substring(lastIndex);

					if(str.equals(".txt")) {
						return true;
					}
				}
				return false;
			}
		};
		paths = dir.listFiles(t1);

		for (File path:paths) {
			System.out.println(path);
		}

	}

	//anonyme avec instantiation en argument
	private void lsFilter3(File dir) {
		File[] paths;

		paths = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.lastIndexOf('.')>0) {

					int lastIndex = name.lastIndexOf('.');
					String str =name.substring(lastIndex);

					if(str.equals(".txt")) {
						return true;
					}
				}
				return false;
			}
		});

		for (File path:paths) {
			System.out.println(path);
		}

	}
	
	// Classe interne
	static class FilterFixedinterne implements FilenameFilter {

		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			if(name.lastIndexOf('.')>0) {

				int lastIndex = name.lastIndexOf('.');
				String str =name.substring(lastIndex);

				if(str.equals(".exe")) {
					return true;
				}
			}
			return false;
		}
	}


	// classe indépendante
	private void lsFilter2(File dir) {
		File[] paths;

		FilterFixed f1 = new FilterFixed();

		paths =dir.listFiles(f1);

		for (File path:paths) {
			System.out.println(path);
		}

	}

	// classe interne
	private void lsFilter4(File dir) {
		File[] paths;
		FilterFixedinterne f1 = new FilterFixedinterne();
		paths =dir.listFiles(f1);

		for (File path:paths) {
			System.out.println(path);
		}

	}

	private void print(File file) {
		System.out.println(file.getAbsolutePath());

	}
}
