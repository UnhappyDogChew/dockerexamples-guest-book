FROM node
WORKDIR /usr/local/src
COPY . .
RUN npm install --production
RUN npm run build

FROM nginx
WORKDIR /usr/share/nginx/html
COPY --from=0 /usr/local/src/build .
CMD ["nginx", "-g", "daemon off;"]