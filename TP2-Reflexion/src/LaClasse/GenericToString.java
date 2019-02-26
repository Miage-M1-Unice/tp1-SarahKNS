package LaClasse;

import java.awt.Point;
import java.awt.Polygon;
import java.lang.reflect.Field;

public class GenericToString {

	public String toString(Object obj, int profondeur) {
		String str = " ";
		Class cl = obj.getClass();
		str += cl.getName();
		str += "[ ";

		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			str += f.getName();
			str += " = ";
			try {
				str += f.get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		str += " ;";
		str += "]";

		str += cl.getInterfaces();
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericToString g = new GenericToString();
		System.out.println(g.toString(new Point(12, 24), 2));

		Polygon pol = new Polygon(new int[] { 10, 20, 30 }, new int[] { 20, 30, 40 }, 3);
		pol.getBounds();
		System.out.println(new GenericToString().toString());
	}

}
