package in.co.rays.java.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testSearch();
		//testAdd();
		//testDelete();
		//testUpdate();
		//testfindByPk();
		//testfindByloginId();

	}

	private static void testfindByloginId() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByLoginId("rohit@gmail.com");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("id not found");
		}

	}

	private static void testfindByPk() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(3);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("id not found");
		}

	}

	private static void testUpdate() throws Exception {


		UserModel model = new UserModel();

		UserBean bean = model.findByPk(14);

		bean.setFirstName("kkk");
		bean.setLastName("ppp");

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(1);

	}

	private static void testSearch() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		bean.setFirstName("v");
		bean.setDob( );

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();

		bean.setId(16);
		bean.setFirstName("ccc");
		bean.setLastName("eee");
		bean.setGender("male");
		bean.setLoginId("aaa@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setPhoneNo("9876567898");
		bean.setAddress("indore");


		try {
			UserModel model = new UserModel();

			model.add(bean);

		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		}

	}
}
