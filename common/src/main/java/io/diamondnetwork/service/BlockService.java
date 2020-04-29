package io.diamondnetwork.service;

import com.github.pagehelper.Page;
import io.diamondnetwork.mapper.BlockMapper;
import io.diamondnetwork.mapper.DashboardMapper;
import io.diamondnetwork.model.Block;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    @Autowired
    private BlockMapper blockDao;
    //查询区块高度小于或等于startHeight的区块列表
    public Page<Block> getBlockList(int startHeight, Integer pageNo, Integer pageSize) {
        int endHeight = startHeight - (pageNo +1) * pageSize;
        Page<Block> list = blockDao.getBlockList(startHeight,endHeight, new RowBounds(pageNo, pageSize));
        int totalBlock = blockDao.countBlocks();
        list.setTotal(totalBlock);
        return list;
    }

    @Autowired
    private DashboardMapper dashboardMapper;

    public Block getBlock(int height) {
        Block list = blockDao.getBlock(height);
        return list;
    }

    public void addBlock(Block block) {
        blockDao.insert(block);
    }
}
