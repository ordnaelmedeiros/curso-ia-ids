%%
clear; clc; close all;

load fisheriris;

clear species;
%%
X2 = meas;

X(:,1) = X2(:,1) .* X2(:,2); 
X(:,2) = X2(:,3) .* X2(:,4);

%X = (X - (repmat(mean(X),150,1))) ./ (repmat(std(X),150,1));

labels = ones(150,1)*-1;

k = 3;

for i=1:k
    %semente(i,:) = rand*mean(X);
    r = round(rand*150);
    semente(i,:) = X(r,:)
end

for i=1:2
    
    for j=1:150
        dist = pdist2(X(j,:), semente);
        [V I] = min(dist);
        labels(j) = I;
    end
    
    for j=1:k
        semente(j,:)= mean(X(labels==j,:));
    end
    
end

gscatter(X(:,1),X(:,2),labels);

for j=1:k
    hold on;
    plot(semente(j,1), semente(j,2), 'd');
    semente(j,:)= mean(X(labels==j,:));
end

hold off;

%close all;    
%gscatter(semente(1,:),semente(2,:),[4 5], 'g');