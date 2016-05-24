package com.demo.service;

import com.demo.domain.Person;
import com.demo.utils.ToastUtil;

import android.content.Context;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class WorkerService {
	private static String objectId = "";

	/**
	 * 创建一条person数据 createPersonData
	 * 
	 * @Title: createPersonData @throws
	 */
	public static void createPerson(final Context context) {
		final Person p2 = new Person();
		p2.setName("lucky");
		p2.setAddress("北京海淀");
		p2.save(context, new SaveListener() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				objectId = p2.getObjectId();
				ToastUtil.showLong(context, "添加数据成功，返回objectId为：" + objectId);
			}

			@Override
			public void onFailure(int code, String msg) {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context, "创建数据失败：" + msg);
			}
		});
	}

	/**
	 * 更新指定objectId的person数据
	 * 
	 * @return void @throws
	 */
	public static void updatePersonByObjectId(final Context context) {
		// 将指定ObjectId的Person这一行数据中的address内容更新为“北京朝阳”
		final Person p2 = new Person();
		p2.setAddress("北京朝阳");
		p2.update(context, objectId, new UpdateListener() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context, "更新成功：更新后的地址->" + p2.getAddress());
			}

			@Override
			public void onFailure(int code, String msg) {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context, "更新失败：" + msg);
			}
		});
	}

	/**
	 * 删除指定ObjectId的person数据 deletePersonByObjectId
	 * 
	 * @Title: deletePersonByObjectId @return void @throws
	 */
	public static void deletePersonByObjectId(final Context context) {
		Person p2 = new Person();
		p2.setObjectId(objectId);
		p2.delete(context, new DeleteListener() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context, "删除成功");
			}

			@Override
			public void onFailure(int code, String msg) {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context, "删除失败：" + msg);
			}
		});
	}

	/**
	 * 查询指定ObjectId的person数据 queryPerson @Title: queryPerson @throws
	 */
	public static void queryPersonByObjectId(final Context context) {
		BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
		bmobQuery.getObject(context, objectId, new GetListener<Person>() {
			@Override
			public void onSuccess(Person object) {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context,"查询成功:名称->" + object.getName() + "，地址->" + object.getAddress());
			}

			@Override
			public void onFailure(int code,String msg) {
				// TODO Auto-generated method stub
				ToastUtil.showLong(context,"查询失败：" + msg);
			}
		});
	}
}
