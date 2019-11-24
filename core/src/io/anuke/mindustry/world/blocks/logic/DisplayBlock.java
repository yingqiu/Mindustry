package io.anuke.mindustry.world.blocks.logic;

import io.anuke.arc.graphics.g2d.*;
import io.anuke.mindustry.world.*;

public class DisplayBlock extends AcceptorLogicBlock{

    public DisplayBlock(String name){
        super(name);
        rotate = false;
    }

    @Override
    public void draw(Tile tile){
        Draw.rect(region, tile.drawx(), tile.drawy());
        LogicEntity entity = tile.entity();

        float dw = 2, dh = 2, xs = 3f, ys = 3f;

        int w = 4, h = 4;
        for(int i = 0; i < w * h; i++){
            int x = i % w;
            int y = i / w;

            if((entity.signal & (1 << i)) != 0){
                Fill.rect(tile.drawx() + x*xs - w * xs/2f, tile.drawy() + y*ys - h * ys/2f, dw, dh);
            }
        }
    }
}
