package com.aconex.simulator.entities.enums;

public enum FuelusageActivity
{
   clearing_plain_land(1),
   visiting_cleared_land(1),
   clearing_rocky_land(2),
   clearing_tree_land (2),
   NOOP(0);

   private int fuelUsage;

   FuelusageActivity(int fuelUsage)
   {
       this.fuelUsage=fuelUsage;

   }
   public int getfuelUsage(){
       return fuelUsage;
   }
}