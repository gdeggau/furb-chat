#include "widget.h"
#include "ui_widget.h"
#include <QSqlTableModel>
#include <QSqlError>
#include <QMessageBox>
#include <QSqlQuery>
#include <QMap>

Widget::Widget(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::Widget)
{
    ui->setupUi(this);

    db = QSqlDatabase::addDatabase("QMYSQL");
    db.setHostName("localhost");
    db.setPort(3306);
    db.setUserName("root");
    db.setPassword("");
    db.setDatabaseName("qdb");

    if (!db.open()) {
        QMessageBox::critical(this, "Erro de conexão", db.lastError().text());
        return;
    }

    model = new QSqlTableModel(this);
    model->setTable("persona");
    model->select();
    ui->tableView->setModel(model);
}

Widget::~Widget()
{
    delete ui;
}

void Widget::on_novoBt_clicked()
{
    QSqlQuery query;
    QString bindId = "7";
    QString bindNome = "Foi!";
    QString bindIdade = "21";
    QString insert = "INSERT INTO persona (id, nome, idade) VALUES ("+bindId+", '"+bindNome+"', "+bindIdade+")";
    query.prepare(insert);
    if (query.exec()) {
        QMessageBox::information(this, "Informação", "Record inserted!");
    } else {
        QMessageBox::critical(this, "Erro de SQL", query.lastError().text());
    }
    model->select();
    QMessageBox::information(this, "Última query", query.lastQuery());
}

void Widget::on_deletarBt_clicked()
{
    model->removeRow(ui->tableView->currentIndex().row());
}

void Widget::on_atualizarBt_clicked()
{
    model->select();
}
