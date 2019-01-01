# mt-java

Uber-jar of the MTJ Heimsund-Halliday Matrix Toolkit for Java: https://github.com/fommil/matrix-toolkits-java

For larger random dense matrices (above ~ 350 x 350) matrix-matrix multiplication C = A.B is about 50% faster than MTJ.

Release 1.1.0 supplements matrix-matrix multiplication with modest multicore capability for larger matrices yielding 
some performance improvements (a few dozen percent for big matrices) in multiplication-heavy algorithms like SVD. 

### Maven:

```xml
<dependency>
    <groupId>com.github.hullbend</groupId>
    <artifactId>mt-java</artifactId>
    <version>1.1.0</version>
</dependency>
```
