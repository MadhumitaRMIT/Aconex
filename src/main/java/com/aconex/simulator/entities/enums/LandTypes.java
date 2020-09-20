package com.aconex.simulator.entities.enums;

public enum LandTypes{
   Plain(FuelusageActivity.clearing_plain_land),
   Rocky(FuelusageActivity.visiting_cleared_land),
   Tree(FuelusageActivity.clearing_rocky_land),
   Protected_Tree(FuelusageActivity.NOOP);

   private FuelusageActivity relevantActivity;

   LandTypes(FuelusageActivity i){
       this.relevantActivity =i;
   }
   public static LandTypes of(char c){
    switch (c) {
        case 'o':
        return LandTypes.Plain;
        case 't':
        return LandTypes.Tree;
        case 'r':
        return LandTypes.Rocky;
        case 'T':
        return LandTypes.Protected_Tree;
        default:
        return LandTypes.Plain;
    }

}
}