package in.co.rays.java.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		testupdate();
//		  testdelete();
//		  testFindByPk();
		// testSearch();

	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		// bean.setId();
		bean.setRollno(116);
		bean.setName("puneet");
		bean.setPhysics(51);
		bean.setChemistry(48);
		bean.setMaths(61);

		try {
			MarksheetModel model = new MarksheetModel();

			model.add(bean);

		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}

	}

	public static void testupdate() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPk(15);

		bean.setName("kkk");

		model.update(bean);

	}

	public static void testdelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(9);

	}

	public static void testFindByPk() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByPk(8);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());

		} else {
			System.out.println(" id not found");
		}
	}

	public static void testFindByRollNo() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByrollNo(110);

		if (bean != null) {
			System.out.print(bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());
			System.out.println("\t" + bean.getId());

		} else {

			System.out.println(" data not found");
		}
	}

	public static void testSearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setName("r");
		bean.setRollno(101);

		MarksheetModel model = new MarksheetModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}
	}

	public static void testReadAll() throws Exception {

		MarksheetModel model = new MarksheetModel();

		List list = model.readAll();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object obj = it.next();

			MarksheetBean bean = (MarksheetBean) obj;

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getRollno());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}

	}
}
