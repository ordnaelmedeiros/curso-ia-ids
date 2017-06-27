function [PC V signals] = runPCA(X)

[N,P] = size(X);
% subtract off the mean for each dimension
mn = mean(X,1);
X = X - repmat(mn,N,1);
% calculate the covariance matrix
covariance = 1 / (N-1) * (X') * X;
% find the eigenvectors and eigenvalues
[PC, V] = eig(covariance);
% extract diagonal of matrix as vector
V = diag(V);
% sort the variances in decreasing order
[junk, rindices] = sort(-1*V);
V = V(rindices);
PC = PC(:,rindices);
%% project the original data set
signals = X * PC(:,1);

