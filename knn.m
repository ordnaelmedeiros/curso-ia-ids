%%
clear; clc; close all;

load fisheriris;
X = meas;
%X = [X(:,1).*X(:,2)  X(:,3).*X(:,4)] ;
%X(:,3:4) = [];
X(:,1:2) = [];
k = [ones(50,1)*1; ones(50,1)*2; ones(50,1)*3];

gscatter(X(:,1),X(:,2),k)
%%

t = [1:5 51:55 101:105];
kteste = k(t);
Xteste = X(t,:);
ktreino = k; ktreino(t) = [];
Xtreino = X; Xtreino(t,:) = [];
%%
[nx ny] = size(Xteste);
kparametro = 1;
%%
for i=1:nx
    x = Xteste(i,:);
    D = pdist2(x,Xtreino)';
    [B I] = sort(D);
    
    I = I(1:k);
    c(i,1) = k(I);
end
%%
result = c == kteste;
sum(result)*100 / length(result)


