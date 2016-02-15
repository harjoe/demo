package test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

import org.junit.Assert;
import org.junit.Test;

import bridge.demo.Car;
import bridge.demo.Person;

public class EhcacheTest {

	/*
	 * @Test public void test() {
	 * 
	 * Car car = new Car();
	 * 
	 * car.setName("bridge");
	 * 
	 * System.out.println(car.getName());
	 * 
	 * fail("Not yet implemented"); }
	 */

	public void testCacheManager() {
		// ����EhCache�����ļ�
		InputStream in = EhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml");
		CacheManager cm = CacheManager.create(in);

		// �г����еĻ������ƣ������������ļ��е�<defaultCache>
		String[] names = cm.getCacheNames();

		// ֻ��һ������Ϊdata-cache��cache
		Assert.assertEquals(1, names.length);
		Assert.assertEquals(names[0], "data-cache");

		// ����ָ�����Ʋ��һ������
		Cache cache = cm.getCache("data-cache"); // ���ݻ������ƻ�ȡ����
		Assert.assertNotNull(cache);

		// ��ȡ������Cache���õĽӿ�
		// CacheConfiguration configuration = cache.getCacheConfiguration();
		// configuration.setTimeToIdleSeconds(3600);

		// �������ڴ��е�������Ϣ���������ö�̬�޸�Ҳ�����ֳ���,
		System.out.println(cm.getActiveConfigurationText());

		// ������л�������ݣ����ǻ��汾����Ȼ����
		// cm.clearAll();

		// ���ڴ���ɾ��һ�������Լ����е����ݣ�Cache������
		// cm.removeCache("data-cache");

	}

	public void testCache() {
		// ֻ�б��г�ʼ����Ч��Cache���������
		// cache.setName("data-cache-changed");
	}

	
	@Test
	public void testAddElementToCache() {
		// ����EhCache�����ļ�
		InputStream in = EhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml");
		CacheManager cm = CacheManager.create(in);

		Cache cache = cm.getCache("data-cache");

		Person p1 = new Person(1, "Jack", 21);
		Person p2 = new Person(2, "Mike", 73);

		cache.putIfAbsent(new Element(p1, p1, 1));
		cache.put(new Element(p2, p2, 1));
		cache.putIfAbsent(new Element(p2, p1, 1));// ֻ��KeyΪp2�����ݲ����ڲŲ���

		// �õ�����p2,������p1
		Element e = cache.get(p2);
		Assert.assertEquals(p2, e.getObjectValue());

		// �����ݴ��ڴ�ˢ��DiskStore����DiskStoreˢ�µ�Disk��
		cache.flush();

	}

	public void testRemoveElementFromCache() {
		// ����EhCache�����ļ�
		InputStream in = EhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml");
		CacheManager cm = CacheManager.create(in);

		Cache cache = cm.getCache("data-cache");

		Person p1 = new Person(1, "Jack", 21);
		Person p2 = new Person(2, "Mike", 73);

		Element e1 = new Element(p1, p1, 1);
		cache.putIfAbsent(e1);
		Element e2 = new Element(p2, p2, 1);
		cache.put(e2);

		cache.remove(p1);
		boolean isSucc = cache.removeElement(e1);
		// e1�Ѿ���ɾ������˲�������false
		Assert.assertFalse(isSucc);

		cache.put(e1);

		cache.removeAll();

		Assert.assertEquals(0, cache.getSize());
	}


	public void testUpdateElementInCache() {
		// ����EhCache�����ļ�
		InputStream in = EhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml");
		CacheManager cm = CacheManager.create(in);

		Cache cache = cm.getCache("data-cache");

		Person p1 = new Person(1, "Jack", 21);
		Person p2 = new Person(2, "Mike", 73);

		Element e1 = new Element(p1, p1, 1);
		cache.put(e1);
		Element e2 = new Element(p2, p2, 1);
		cache.put(e2);

		e2 = new Element(p2, p1, 1);
		cache.replace(e2);

		Assert.assertEquals(p1, e2.getObjectValue());

	}

	public void testQueryElementsFromCache() {
		InputStream in = Ehcache.class.getClassLoader().getResourceAsStream("ehcache.xml");
		CacheManager cm = CacheManager.create(in);
		Cache cache = cm.getCache("data-cache");

		// EhCache�е�����������Element��������Key,Value��һ���汾��Ϣ
		Element e = new Element(1000, 10000, 1);
		cache.put(e);

		// ��ӵڶ�������
		e = new Element(2000, 20000, 1);
		cache.put(e);

		// ����������������
		Assert.assertEquals(2, cache.getSize());

		// ͨ��get�������key��Ӧ������
		e = cache.get(1000);
		Assert.assertEquals(10000, e.getObjectValue());

		// ������ѯ
		Query q = cache.createQuery();

		// Cacheû�������κβ�ѯ���ԣ�����쿴��Ĭ�ϵĲ�ѯ��������Щ
		// set�а��������ɲ�ѯԪ�أ�key��value
		// Set<Attribute> set = cache.getSearchAttributes();

		// �����Ƿ����࣬�õ�key��Ӧ�Ĳ�ѯ���Զ���
		Attribute<Integer> keyAttribute = cache.getSearchAttribute("key"); // ����Ĭ���ṩ�Ŀɲ�ѯ����key���в�ѯ

		// �����ѯ����,����һ����ʽд����һ��Query�������д�����ѯ����
		// ��������key��ֵΪ2000�Ĳ�ѯ
		q = q.addCriteria(keyAttribute.eq(2000));

		// �����includeKeys��q.includeValues();,����Խ�����в�����Keys��Values��Ϣ
		q.includeKeys();
		q.includeValues();

		// ִ�в�ѯ
		Results results = q.execute();// ִ�в�ѯ
		Assert.assertNotNull(results);
		Assert.assertEquals(results.size(), 1);

		// �г����н��
		List<Result> resultList = results.all();
		Result result = resultList.get(0);
		Assert.assertEquals(2000, result.getKey());

		Assert.assertEquals(20000, result.getValue());
	}

}
