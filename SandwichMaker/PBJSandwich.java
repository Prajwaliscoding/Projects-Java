public class PBJSandwich {
 // Instance variables (never null; default to default objects)
 private Bread topSlice = new Bread();
 private PeanutButter peanutButter = new PeanutButter();
 private Jelly jelly = new Jelly();
 private Bread bottomSlice = new Bread();

 // ----- Constructors -----
 public PBJSandwich() { }

 public PBJSandwich(Bread top, PeanutButter pb, Jelly j, Bread bottom) {
     setTopSlice(top);
     setPeanutButter(pb);
     setJelly(j);
     setBottomSlice(bottom);
 }

 // ----- Accessors -----
 public Bread getTopSlice() { return topSlice; }
 public PeanutButter getPeanutButter() { return peanutButter; }
 public Jelly getJelly() { return jelly; }
 public Bread getBottomSlice() { return bottomSlice; }

 // ----- Mutators with non-null checks -----
 public void setTopSlice(Bread top) {
     this.topSlice = (top != null) ? top : new Bread();
 }
 public void setPeanutButter(PeanutButter pb) {
     this.peanutButter = (pb != null) ? pb : new PeanutButter();
 }
 public void setJelly(Jelly j) {
     this.jelly = (j != null) ? j : new Jelly();
 }
 public void setBottomSlice(Bread bottom) {
     this.bottomSlice = (bottom != null) ? bottom : new Bread();
 }

 // ----- Equality -----
 // Per spec: call Equals of each component (we use equals(Object) overrides)
 public boolean equals(PBJSandwich other) {
     if (other == null) return false;
     return this.topSlice.equals(other.topSlice)
         && this.peanutButter.equals(other.peanutButter)
         && this.jelly.equals(other.jelly)
         && this.bottomSlice.equals(other.bottomSlice);
 }

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (!(o instanceof PBJSandwich)) return false;
     return equals((PBJSandwich) o);
 }

 @Override
 public String toString() {
     // Concatenate all instance variable values, formatted similar to example
     StringBuilder sb = new StringBuilder();
     sb.append("PBJ Sandwich\n");
     sb.append("Top Slice:\n").append(topSlice.toString());
     sb.append("Peanut Butter:\n").append(peanutButter.toString());
     sb.append("Jelly:\n").append(jelly.toString());
     sb.append("Bottom Slice:\n").append(bottomSlice.toString());
     return sb.toString();
 }
}
