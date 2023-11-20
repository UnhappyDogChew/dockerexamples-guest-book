FROM node
WORKDIR /usr/local/src
COPY . .
RUN yarn install --production
RUN yarn run build

FROM nginx
WORKDIR /usr/share/nginx/html
COPY --from=0 /usr/local/src/build .
CMD ["nginx", "-g", "daemon off;"]