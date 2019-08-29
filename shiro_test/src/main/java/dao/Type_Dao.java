package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import entity.Type;

@Repository
public interface Type_Dao {
	@Select("select count(1) from type   ${txt} ")
	public int selectCount(@Param("txt") String txt);
	
	@Select("select * from type ${txt} ${limit}")
	@Cacheable(value="myselect")
	public List<Type> select(@Param("txt") String txt,@Param("limit") String limit);
	
	@Select("select * from type where id=#{id}")
	public Type selectById(int id);
	
	@Insert("insert into type (id,name) values(#{id},#{name})")
	@CacheEvict(value="myselect",allEntries=true)	
	public int insert(Type t);
	
	@Update("update type set name=#{name} where id=#{id}")
	public void update(Type t);
	
	@Delete("delete from type where id=#{id} ")
	public void delete(int id);
	
	
}
