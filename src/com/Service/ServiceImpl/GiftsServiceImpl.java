package com.Service.ServiceImpl;

import com.DAO.IGiftDAO;
import com.DAO.DAOImpl.GiftsDaoImpl;
import com.Bean.Gifts;
import com.Bean.Page;
import com.Service.GiftsService;

import java.sql.SQLException;
import java.util.List;

public class GiftsServiceImpl implements GiftsService {
        private IGiftDAO giftsDao=new GiftsDaoImpl();
    @Override
    public int addGifts(Gifts gifts) throws SQLException {
        return giftsDao.addGifts(gifts);
    }

    @Override
    public int deleteGiftsById(Integer id) throws SQLException {
        return giftsDao.deleteGiftsById(id);
    }

    @Override
    public int updateGifts(Gifts gifts) throws SQLException {
        return giftsDao.updateGifts(gifts);
    }

    @Override
    public Gifts queryGiftsById(Integer id) throws SQLException {
        return giftsDao.queryGiftsById(id);
    }

    @Override
    public List<Gifts> queryGifts() throws SQLException {
        return giftsDao.queryGifts();
    }

    @Override
    public Page<Gifts> page(int pageNo, int pageSize) throws SQLException {
        Page<Gifts> page=new Page<Gifts>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=giftsDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总的页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的起始索引
        int begin=(page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Gifts> items=giftsDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Gifts> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException {
        Page<Gifts> page=new Page<Gifts>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount=giftsDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总的页码
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的起始索引
        int begin=(page.getPageNo()-1)*pageSize;
        //求当前页数据
        List<Gifts> items=giftsDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
