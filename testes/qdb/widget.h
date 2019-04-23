#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include <QSqlDatabase>

namespace Ui {
class Widget;
}

class QSqlTableModel;

class Widget : public QWidget
{
    Q_OBJECT

public:
    explicit Widget(QWidget *parent = nullptr);
    ~Widget();

private slots:
    void on_novoBt_clicked();

    void on_deletarBt_clicked();

    void on_atualizarBt_clicked();

private:
    Ui::Widget *ui;
    QSqlTableModel *model;
    QSqlDatabase db;
};

#endif // WIDGET_H
