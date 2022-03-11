FROM node:alpine AS builder
LABEL maintainer="Kevin Candia @kevinkeyssx build ui"
WORKDIR /app
COPY . /app
RUN npm install && \
    npm run build
FROM nginx:alpine
COPY --from=builder /app/dist/* /usr/share/nginx/html/
COPY /nginx.conf /etc/nginx/conf.d/default.conf