package exo1a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FilterFixed implements FilenameFilter {
	
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
	





