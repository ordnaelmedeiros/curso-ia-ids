%%
load fisheriris;
X = meas;

figure(1);
gscatter(X(:,1).*X(:,2),X(:,3).*X(:,4),species);
%%
[PC V signals] = runPCA(X);

figure(2);
gscatter(signals(:,1),signals(:,2),species);